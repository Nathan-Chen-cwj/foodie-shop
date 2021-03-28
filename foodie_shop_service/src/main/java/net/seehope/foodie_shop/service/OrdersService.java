package net.seehope.foodie_shop.service;

import net.seehope.foodie_shop.bo.OrderBo;
import net.seehope.foodie_shop.pojo.OrderStatus;
import net.seehope.foodie_shop.vo.OrdersVo;
import net.seehope.foodie_shop.vo.OrdersVo1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/3 14:05
 */
public interface OrdersService {
    /**
     * 创建订单
     * @param orderBo
     * @return
     */
    public OrdersVo1 createOrders(OrderBo orderBo);


    /**
     * 通过订单号来查看订单是否已支付
     * @param oid
     * @return OrderStatus对象
     */
    public OrderStatus queryOrderStatusByOid(String oid);

    /**
     * 根据用户手机号码查询订单信息
     * @param mobile 用户手机号码
     * @return
     */
    public List<OrdersVo> queryOrdersByUserMobile(String mobile);

    /**
     * 通过收件人手机号码来查找订单信息
     * @param mobile
     * @return
     */
    public List<OrdersVo> queryOrderByReceiverMobile(String mobile);

    /**
     * 成功支付
     * @param out_trade_no 订单号
     * @return
     */
    public boolean successPay(String out_trade_no);
}
