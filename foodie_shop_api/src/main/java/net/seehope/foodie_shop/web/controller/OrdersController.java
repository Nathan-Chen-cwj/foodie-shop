package net.seehope.foodie_shop.web.controller;

import com.alipay.api.AlipayApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.seehope.foodie_shop.bo.OrderBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.pojo.OrderStatus;
import net.seehope.foodie_shop.service.OrdersService;
import net.seehope.foodie_shop.utils.AliPayUtils;
import net.seehope.foodie_shop.vo.OrdersVo;
import net.seehope.foodie_shop.vo.OrdersVo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/3 11:08
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/create")
    public JsonResult createOrders(@RequestBody OrderBo orderBo){
        OrdersVo1 orders = ordersService.createOrders(orderBo);
        return JsonResult.isOk(orders);
    }
//    http://127.0.0.1:8080/orders/getPaidOrderInfo?orderId=[object%20Object]
    @GetMapping("/getPaidOrderInfo")
    public JsonResult getPaidOrderInfo(@RequestParam String orderId) {
        System.out.println("go into getPaidOrderInfo"+orderId);
        try{
            OrderStatus orderStatus = ordersService.queryOrderStatusByOid(orderId);
            return JsonResult.isOk(orderStatus);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
