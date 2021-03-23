package net.seehope.foodie_shop.web.admin.controller;

import net.seehope.foodie_shop.bo.GoodsBo;
import net.seehope.foodie_shop.common.JsonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/22 21:12
 * 管理员操作修改数据api
 */
@RestController
@RequestMapping("/updateData")
public class AdminOperateData {
    @GetMapping("/putGoodsOnSell")
    public JsonResult putGoodsOnSell(@RequestBody List<GoodsBo> goodsBoList){
        return null;
    }
    @GetMapping("/offGoodsDownSell")
    public JsonResult offGoodsDownSell(@RequestParam String goodsId){
        return null;
    }
    @GetMapping("/updateGoodsMsg")
    public JsonResult updateGoodsMsg(){
        return null;
    }

    @GetMapping("/deleteGoodsMsg")
    public JsonResult deleteGoodsMsg(@RequestParam String goodsId){
        return null;
    }
}
