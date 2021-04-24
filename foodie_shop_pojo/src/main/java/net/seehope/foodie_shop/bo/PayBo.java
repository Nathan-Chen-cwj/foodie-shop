package net.seehope.foodie_shop.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/4/17 14:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayBo {
    private String orderId;
    private String totalAmount;
}
