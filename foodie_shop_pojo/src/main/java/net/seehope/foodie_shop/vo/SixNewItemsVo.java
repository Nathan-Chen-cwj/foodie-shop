package net.seehope.foodie_shop.vo;

import lombok.Data;

import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/29 19:20
 */
@Data
public class SixNewItemsVo {
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;
    private List<SimpleItemVo> simpleItemList;
}
