package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.pojo.OrderItems;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface OrderItemsMapper extends tk.mybatis.mapper.common.Mapper<OrderItems> {

    public Integer createOrder(OrderItems orderItems);

}




