package net.seehope.foodie_shop.vo;

import lombok.Data;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/30 11:51
 */
@Data
public class ItemSpecListVo {
    //id name priceDiscount priceNormal discount
    private String id;
    private String url;
    private String name;
    private String priceDiscount;
    private String priceNormal;
    private String discounts;
    private String stock;
}
