package net.seehope.foodie_shop.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/30 11:03
 */
@Data
public class ItemInfoVo {
    /**
     * i.item_name,
     * 	i.sell_counts,
     * 	i.content,
     * 	ip.eat_method,
     * 	ip.storage_method,
     * 	ip.weight,
     * 	ip.foot_period,
     * 	ip.packaging_method,
     * 	ip.factory_address,
     * 	ip.produc_place,
     * 	ip.brand,
     * 	ip.factory_name,
     * 	ii.url,
     * 	ii.is_main,
     * 	ic.id,
     * 	ic.name,
     * 	ic.price_discount,
     * 	ic.price_normal,
     * 	ic.stock,
     * 	ic.discounts
     * itemInfo{
     *   items   item{ id,itemName,sellCounts }
     *   items_spec  itemSpecList[id name priceDiscount priceNormal discounts stock]
     *   items_img itemImgList[url,sort,isMain]
     *   items_param itemParams{producPlace packing_method brand factoryName factoryAddress footPeriod weight storageMethod eatMethod} 产品详细信息
     *     }
     */
    private String itemInfoId;
    private ItemVo item;
    private List<ItemSpecListVo> itemSpecList = new ArrayList<ItemSpecListVo>();
    private List<ItemImgListVo> itemImgList = new ArrayList<ItemImgListVo>();
    private ItemParamsVo itemParams;

}
