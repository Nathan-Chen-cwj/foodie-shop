package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.dto.OrderDataDto;
import net.seehope.foodie_shop.pojo.ItemsSpec;
import net.seehope.foodie_shop.vo.ItemSpecListVo;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface ItemsSpecMapper extends tk.mybatis.mapper.common.Mapper<ItemsSpec> {
    List<ItemSpecListVo> queryItemSpecListVo(String itemId);

    List<OrderDataDto> queryOrderData(List<String> ids);


}




