package net.seehope.foodie_shop.vo;

import lombok.Data;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/1 16:01
 *
 *购物车渲染项
 */
@Data
public class ShopCarItemVo {
    private String itemName;
    private String itemId;

    private String specName;
    private String specId;
    private String priceNormal;
    private String priceDiscount;

    private String itemImgUrl;
}
