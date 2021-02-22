package net.seehope.foodie_shop.web.controller;

import net.seehope.foodie_shop.bo.OrderBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/create")
    public JsonResult createOrders(@RequestBody OrderBo orderBo){
        return JsonResult.isOk(ordersService.createOrders(orderBo));
    }
}
