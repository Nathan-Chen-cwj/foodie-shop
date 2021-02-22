package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.pojo.ItemsImg;
import net.seehope.foodie_shop.vo.ItemImgListVo;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface ItemsImgMapper extends tk.mybatis.mapper.common.Mapper<ItemsImg> {
    List<ItemImgListVo> queryItemImgListVo(String itemId);
}




