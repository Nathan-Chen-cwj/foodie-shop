package net.seehope.foodie_shop.dto;

import lombok.Data;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/3 16:00
 */
@Data
public class OrderDataDto {
    private String itemId;
    private String itemImg;
    private String itemName;
    private String itemSpecId;
    private String itemSpecName;
    private Integer priceNormal;
    private Integer priceDiscount;
}
