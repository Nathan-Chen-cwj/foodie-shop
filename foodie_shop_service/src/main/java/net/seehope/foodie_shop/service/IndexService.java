package net.seehope.foodie_shop.service;

import net.seehope.foodie_shop.vo.CategoryChildVo;
import net.seehope.foodie_shop.vo.CategoryRootVo;
import net.seehope.foodie_shop.vo.RenderCarouselVo;
import net.seehope.foodie_shop.vo.SixNewItemsVo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/29 10:44
 *
 * 首页图片渲染
 */
public interface IndexService {
    /**
     * 获取轮播图信息
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public List<RenderCarouselVo> getRenderCarouselVo() throws InvocationTargetException, IllegalAccessException;

    /**
     * 获取大的分类信息
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public List<CategoryRootVo> getCategoryRootItemsList() throws InvocationTargetException, IllegalAccessException;

    /**
     * 获取二级分类
     * @param rootCatId
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public List<CategoryChildVo> getCategoryChildItemsList(Integer rootCatId) throws InvocationTargetException, IllegalAccessException;

    /**
     * 查询推荐商品
     * @param rootCatId
     * @return
     */
    public SixNewItemsVo renderSixNewItems(Integer rootCatId);

}
