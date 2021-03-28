package net.seehope.foodie_shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/28 20:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsListVo {
    private String itemId;
    private String itemName;
    private String price;
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
