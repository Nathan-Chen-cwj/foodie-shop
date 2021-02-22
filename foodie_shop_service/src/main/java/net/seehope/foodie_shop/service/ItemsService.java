package net.seehope.foodie_shop.service;

import net.seehope.foodie_shop.pojo.Items;
import net.seehope.foodie_shop.vo.*;

import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/29 21:57
 *
 * 商品查询
 */
public interface ItemsService {
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
    ItemInfoVo queryItemDetails(String itemId);

    /**
     * 搜索栏搜索商品
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    SearchItemVo searchItems(String keywords, String sort, Integer page, Integer pageSize);

    /**
     * 展示评论等级人数统计
     * @param itemId
     * @return
     */
    ShowCommentsVo renderCommentLevelCounts(String itemId);

    RenderCommentsVo renderComments(String itemId,String level,String page,String pageSize);

    List<ShopCarItemVo> queryShopCarItems(String[] specIds);

}
