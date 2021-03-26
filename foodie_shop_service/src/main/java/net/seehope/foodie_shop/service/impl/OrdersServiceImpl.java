package net.seehope.foodie_shop.service.impl;

import com.alipay.api.AlipayApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.seehope.foodie_shop.bo.OrderBo;
import net.seehope.foodie_shop.dto.OrderDataDto;
import net.seehope.foodie_shop.exception.CreateOrderItemsException;
import net.seehope.foodie_shop.mapper.ItemsSpecMapper;
import net.seehope.foodie_shop.mapper.OrderItemsMapper;
import net.seehope.foodie_shop.mapper.OrdersMapper;
import net.seehope.foodie_shop.mapper.UserAddressMapper;
import net.seehope.foodie_shop.pojo.OrderItems;
import net.seehope.foodie_shop.pojo.Orders;
import net.seehope.foodie_shop.pojo.UserAddress;
import net.seehope.foodie_shop.service.OrdersService;
import net.seehope.foodie_shop.utils.AliPayUtils;
import net.seehope.foodie_shop.vo.OrdersVo;
import org.apache.commons.lang3.StringUtils;
import org.mayanjun.code.idworker.IdWorker;
import org.mayanjun.code.idworker.IdWorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/3 14:31
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private ItemsSpecMapper itemsSpecMapper;

    @Autowired
    private OrderItemsMapper orderItemsMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    /**
     * 先拿到 itemSpecIds 再从里面遍历获取 item_spec的id
     *
     * 然后去查询item_spec 表，获取到item_id,id,name
     * items_img表 item_img,  items表 item_name  返回对象数组
     *
     * 查询到的数据封装在一个数组里面 orderId 在同一个订单中只有一个
     * orders的id每一项都不同
     */
    @Override
    public OrdersVo createOrders(OrderBo orderBo) {
        String itemSpecIds = orderBo.getItemSpecIds();
        String [] SpecIds = StringUtils.split(itemSpecIds,",");
        List<String> ids = Arrays.asList(SpecIds);
        IdWorker idWorker = IdWorkerFactory.create();
        String orderId = String.valueOf(idWorker.nextId());
        Integer priceDiscount = 0;
        Integer priceNormal = 0;
        int i = 0;
        List<OrderDataDto> orderDataDtos = itemsSpecMapper.queryOrderData(ids);
        for (OrderDataDto orderDataDto : orderDataDtos) {
            OrderItems orderItems = new OrderItems();
            orderItems.setId(String.valueOf(idWorker.nextId()));
            orderItems.setOrderId(orderId);
            orderItems.setItemId(orderDataDto.getItemId());
            orderItems.setItemImg(orderDataDto.getItemImg());
            orderItems.setItemName(orderDataDto.getItemName());
            orderItems.setItemSpecId(orderDataDto.getItemSpecId());
            priceDiscount += orderDataDto.getPriceDiscount();
            orderItems.setPrice(orderDataDto.getPriceDiscount());
            priceNormal += orderDataDto.getPriceNormal();
            orderItems.setItemSpecName(orderDataDto.getItemSpecName());
            orderItems.setBuyCounts(1);
           if( orderItemsMapper.insert(orderItems) == 0){
               throw  new CreateOrderItemsException("系统异常，插入订单项失败，请稍后再试");
           }
           i+=i;
        }
        Orders orders = new Orders();
        orders.setId(orderId);
        orders.setUserId(orderBo.getUserId());
        orders.setPayMethod(orderBo.getPayMethod());
        orders.setLeftMsg(orderBo.getLeftMsg());
        orders.setCreatedTime(new Date());
        orders.setUpdatedTime(new Date());
        orders.setRealPayAmount(priceDiscount);
        orders.setTotalAmount(priceNormal);
        orders.setPostAmount(0);
        orders.setIsComment(0);
        orders.setIsDelete(0);
        UserAddress userAddress = userAddressMapper.selectByPrimaryKey(orderBo.getAddressId());
        String receiverAddress = userAddress.getProvince()+ userAddress.getCity()+ userAddress.getDistrict()+ userAddress.getDetail();
        orders.setReceiverName(userAddress.getReceiver());
        orders.setReceiverMobile(userAddress.getMobile());
        orders.setReceiverAddress(receiverAddress);
        if(ordersMapper.insert(orders) == 0){
            throw  new CreateOrderItemsException("系统异常，订单创建失败，请稍后再试");
        }
        return new OrdersVo(orderId);
    }

    @Override
    public boolean toPayOrder(String orderId, double amount) {
        String str = null;
        try {
            str = AliPayUtils.generateAliPayTradePagePayRequestForm(orderId, "沙箱支付学习", amount);
            if (str != null){
                return true;
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
