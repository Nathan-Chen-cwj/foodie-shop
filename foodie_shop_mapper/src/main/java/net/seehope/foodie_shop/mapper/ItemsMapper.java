package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.pojo.Items;
import net.seehope.foodie_shop.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface ItemsMapper extends tk.mybatis.mapper.common.Mapper<Items> {
    /**
     * 推荐商品查询
     * @param rootCatId
     * @return
     */
    List<SimpleItemVo> querySimpleItemVo(Integer rootCatId);

    /**
     * 点击商品图片查看商品详情
     * @param itemId
     * @return
     */
    ItemVo queryItemVo(String itemId);

    /**
     * 搜索栏搜索
     * @param keywords
     * @param sort
     * @return
     */
    List<RowsVo> searchRowsVo(String keywords, String sort);

    ItemInfoVo queryItemInfoVoByItemsId(String itemId);

    /**
     * @Param("specIdsT") 指定该list的别名，用于在mapper.xml中进行循环获取时的collection名称
     * @param specIds
     * @return
     */
    List<ShopCarItemVo> queryShopCarOperation(@Param("specIds")List<String>  specIds);

}




