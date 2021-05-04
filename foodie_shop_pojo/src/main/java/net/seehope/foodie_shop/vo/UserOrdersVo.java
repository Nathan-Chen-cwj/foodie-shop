package net.seehope.foodie_shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/5/4 23:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrdersVo {
    private String orderId;
    private String name;
    private String address;
    private int price;
    private Date downDate;
}
