package net.seehope.foodie_shop.bo;

import lombok.Data;

import java.util.Date;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/28 22:32
 */
@Data
public class ItemBo {
    private String id;
    private String itemName;
    /**
     * 分类外键id 分类id
     */
    private int catId;
    /**
     * 一级分类外键id
     */
    private int rootCatId;
    /**
     * 售出量
     */
    private int sellCounts;
    /**
     * 产品状态 1上架 2下架
     */
    private int onOffStatus;
    /**
     * 商品商家描述
     */
    private String content;
    /**
     * 产地 产地，例：中国江苏
      */
    private String produc_place;
    /**
     * 保质期 保质期，例：180天
     */
    private String footPeriod;
    /**
     * 品牌名，例：三只大灰狼
     */
    private String brand;
    /**
     * 生产厂名，例：大灰狼工厂
     */
    private String factoryName;
    /**
     * 生产厂址，例：大灰狼生产基地
     */
    private String factoryAddress;
    /**
     * 包装方式，例：袋装
     */
    private String packagingMethod;
    /**
     * 规格重量，例：35g
     */
    private String weight;
    /**
     * 存储方法，例：常温5~25°
     */
    private String storageMethod;
    /**
     * 食用方式，例：开袋即食
      */
    private String eatMethod;


}
