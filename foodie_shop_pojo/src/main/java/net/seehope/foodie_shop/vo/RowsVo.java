package net.seehope.foodie_shop.vo;

import lombok.Data;

import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/30 23:06
 */
@Data
public class RowsVo {
    private String itemId;
    private String itemName;
    private String price;
    private String sellCounts;
    private String imgUrl;
}
