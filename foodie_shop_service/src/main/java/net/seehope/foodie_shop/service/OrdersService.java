package net.seehope.foodie_shop.service;

import net.seehope.foodie_shop.bo.OrderBo;
import net.seehope.foodie_shop.vo.OrdersVo;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/3 14:05
 */
public interface OrdersService {
    public OrdersVo createOrders(OrderBo orderBo);
}
