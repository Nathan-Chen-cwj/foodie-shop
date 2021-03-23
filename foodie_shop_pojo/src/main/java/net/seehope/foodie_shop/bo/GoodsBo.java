package net.seehope.foodie_shop.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/22 21:27
 */
@Data
public class GoodsBo {
    private String goodsName;
    private List<String> goodsImg;
    private BigDecimal price;
}
