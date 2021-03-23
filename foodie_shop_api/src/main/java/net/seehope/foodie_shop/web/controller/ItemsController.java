package net.seehope.foodie_shop.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.service.ItemsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/30 10:52
 */
@Tag(name = "items",description = "商品项相关显示控制器")
@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;


    @Tag(name = "itemDetails",description = "点击商品选项卡，查询商品详情")
    @GetMapping("/info/{itemId}")
    public JsonResult itemDetails(@PathVariable String itemId){
        return JsonResult.isOk(itemsService.queryItemDetails(itemId));
    }

    @Tag(name = "search",description = "根据关键词，进行关键词分页查询")
    @GetMapping("/search")
    public JsonResult searchItems(@RequestParam String keywords,String sort,Integer page,Integer pageSize){
        return JsonResult.isOk(itemsService.searchItems(keywords,sort,page,pageSize));
    }

    @Tag(name = "commentLevel",description = "查询某一个商品的评论总数以及各分级下商品评论数")
    @GetMapping("/commentLevel")
    public JsonResult renderCommentLevelCounts(@RequestParam String itemId){
        return JsonResult.isOk(itemsService.renderCommentLevelCounts(itemId));
    }

    @Tag(name = "comments",description = "根据评论等级进行分页显示商品评论")
    @GetMapping("/comments")
    public JsonResult renderComments(@RequestParam String itemId,String level,String page,String pageSize){
        return JsonResult.isOk(itemsService.renderComments(itemId, level, page, pageSize));
    }

    @Tag(name = "refresh",description = "显示购物车商品项，实时更新购物车商品项")
    @GetMapping("/refresh")
    public JsonResult renderShopCatItems(@RequestParam String itemSpecIds){
        return  JsonResult.isOk(itemsService.queryShopCarItems(StringUtils.splitByWholeSeparatorPreserveAllTokens(itemSpecIds,",")));
    }

    @GetMapping("/catItems")
    public JsonResult catItems(@RequestParam Integer catId,String sort,Integer page,Integer pageSize){
        return JsonResult.isOk(itemsService.searchCatItems(catId,sort,page,pageSize));
    }
}
