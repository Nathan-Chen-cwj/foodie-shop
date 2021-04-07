package net.seehope.foodie_shop.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author NathanChen
 * @Date 2021/3/29 18:24
 * @Version 1.0
 */
@Data
public class OrderListVo {
    private String orderId;
    private String receiverName;
    private String receiverMobile;
    private String receiverAddress;
    private int orderStatus;
    private String leftMsg;
    private String createTime;
}
