package net.seehope.foodie_shop.web.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.mapper.CategoryMapper;
import net.seehope.foodie_shop.pojo.Category;
import net.seehope.foodie_shop.security.web.config.CorsConfig;
import net.seehope.foodie_shop.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.InvocationTargetException;


/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/28 21:03
 */
@RestController
@RequestMapping("/index")
@Tag(name = "IndexController",description = "首页前端控制器")
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 解决同源策略问题配置项
     */
    @Autowired
    private CorsConfig corsConfig;

    @Tag(name = "carousel",description = "首页轮播图显示控制器")
    @GetMapping("/carousel")
    public JsonResult carousel() throws InvocationTargetException, IllegalAccessException {
        return JsonResult.isOk(indexService.getRenderCarouselVo());
    }

    @Tag(name = "cats",description = "首页主侧边商品分类栏显示控制器")
    @GetMapping("/cats")
    public JsonResult cats() throws InvocationTargetException, IllegalAccessException {
        return JsonResult.isOk(indexService.getCategoryRootItemsList());
    }

    @Tag(name = "subCat",description = "首页二三级商品分类显示控制器")
    @GetMapping("/subCat/{rootCatId}")
    public JsonResult subCat(@PathVariable Integer rootCatId) throws InvocationTargetException, IllegalAccessException {
        return JsonResult.isOk(indexService.getCategoryChildItemsList(rootCatId));
    }

    /**
     * 大项里面的最新的六个商品
     * @param rootCatId
     * @return
     */
    @Tag(name = "sixNewItems",description = "首页商品推荐显示控制器")
    @GetMapping("/sixNewItems/{rootCatId}")
    public JsonResult renderSixNewItems(@PathVariable Integer rootCatId){
        return JsonResult.isOk(indexService.renderSixNewItems(rootCatId));
    }
}
