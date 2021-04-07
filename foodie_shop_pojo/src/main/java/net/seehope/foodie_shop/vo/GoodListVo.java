package net.seehope.foodie_shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author NathanChen
 * @Date 2021/3/29 18:12
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodListVo {
    private String itemId;
    private String itemSpecId;
    private String itemName;
    /**
     * 规格名称
     */
    private String flavor;
    private int price;
    /**
     * 库存
     */
    private int stock;
    /**
     * 销售量
     */
    private int sellCounts;
    /**
     * 商品状态 1上架 2下架
     */
    private int goodsStatus;
}
