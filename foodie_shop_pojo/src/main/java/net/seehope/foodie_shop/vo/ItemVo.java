package net.seehope.foodie_shop.vo;

import lombok.Data;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/30 11:54
 */
@Data
public class ItemVo {
    //item{ id,itemName,sellCounts,context }
    private String content;
    private String id;
    private String itemName;
    private String sellCounts;

}
