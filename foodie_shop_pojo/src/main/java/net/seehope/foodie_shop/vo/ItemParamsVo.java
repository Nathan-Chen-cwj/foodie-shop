package net.seehope.foodie_shop.vo;

import lombok.Data;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/30 12:05
 */
@Data
public class ItemParamsVo {
    // producPlace brand factoryName factoryAddress footPeriod weight storageMethod eatMethod
    private String producPlace;
    private String brand;
    private String factoryName;
    private String factoryAddress;
    private String footPeriod;
    private String weight;
    private String storageMethod;
    private String eatMethod;
    private String packagingMethod;
}
