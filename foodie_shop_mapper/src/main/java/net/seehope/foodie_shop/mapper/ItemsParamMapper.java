package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.pojo.ItemsParam;
import net.seehope.foodie_shop.vo.ItemParamsVo;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface ItemsParamMapper extends tk.mybatis.mapper.common.Mapper<ItemsParam> {
    ItemParamsVo queryItemParamsVo(String itemId);
}




