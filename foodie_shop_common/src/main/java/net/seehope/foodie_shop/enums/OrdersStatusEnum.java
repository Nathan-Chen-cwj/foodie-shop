package net.seehope.foodie_shop.enums;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 20:09
 */
public enum  OrdersStatusEnum {
    /**
     * 交易状态枚举
     */

     TO_BE_PAID(1,"待支付"),
     PAID(2,"已支付"),
     DELIVERED(3,"待收货"),
     SUCCESSFUL_TRADE(4,"交易成功"),
     TRANSACTION_CLOSURE(5,"交易关闭");

     public final int type;
     public final String content;

     private OrdersStatusEnum(int type, String content) {
         this.type = type;
         this.content = content;
     }
}

