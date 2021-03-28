package net.seehope.foodie_shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/3 14:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersVo {
    private String orderId;
    private String receiverName;
    private String receiverMobile;
    private String receiverAddress;
    private double realPayAmount;
    private String leftMsg;
    private Date createTime;
}
