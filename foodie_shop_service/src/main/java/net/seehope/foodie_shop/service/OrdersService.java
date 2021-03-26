package net.seehope.foodie_shop.service;

import net.seehope.foodie_shop.bo.OrderBo;
import net.seehope.foodie_shop.vo.OrdersVo;


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
    public OrdersVo createOrders(OrderBo orderBo);

    /**
     * 订单支付
     * @param orderId 订单id
     * @param amount 金额
     * @return
     */
    public boolean toPayOrder(String orderId, double amount);
}
