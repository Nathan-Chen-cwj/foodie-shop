package net.seehope.foodie_shop.web.admin.controller;

import net.seehope.foodie_shop.bo.GoodsBo;
import net.seehope.foodie_shop.bo.ItemBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AdminService adminService;

    @GetMapping("/putGoodsOnSell")
    public JsonResult putGoodsOnSell(@RequestBody List<GoodsBo> goodsBoList){
        return null;
    }

    @GetMapping("/offGoodsDownSell")
    public JsonResult offGoodsDownSell(@RequestParam String goodsId){
        return null;
    }

    @GetMapping("/updateGoodsMsg")
    public JsonResult updateGoodsMsg(@RequestBody ItemBo itemBo){
        return null;
    }

    @GetMapping("/deleteGoodsMsg")
    public JsonResult deleteGoodsMsg(@RequestParam String goodsId){
        return null;
    }

    @PostMapping()
    public JsonResult addItem(@RequestBody ItemBo itemBo){
        return null;
    }
}
