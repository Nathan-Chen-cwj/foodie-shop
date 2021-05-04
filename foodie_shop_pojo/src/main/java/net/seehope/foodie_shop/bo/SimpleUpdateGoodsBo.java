package net.seehope.foodie_shop.bo;

import lombok.Data;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/29 22:27
 */
@Data
public class SimpleUpdateGoodsBo {
    private String itemId;
    private String itemSpecId;
    private String itemName;
    private double price;
    private int stock;
    private String flavor;
    private int sellCounts;
    private int goodsStatus;
}
