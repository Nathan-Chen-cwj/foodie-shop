package net.seehope.foodie_shop.web.admin.controller;

import net.seehope.foodie_shop.bo.GoodsBo;
import net.seehope.foodie_shop.bo.ItemBo;
import net.seehope.foodie_shop.bo.SimpleUpdateGoodsBo;
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
    public JsonResult putGoodsOnSell(@RequestParam List<String> itemId){
        System.out.println(itemId);
        int i = adminService.putGoodsOnSell(itemId);
        if (i>0){
            return JsonResult.isOk("i");
        }
        return JsonResult.err("系统异常，设置失败");
    }

    @GetMapping("/offGoodsDownSell")
    public JsonResult offGoodsDownSell(@RequestParam List<String> itemId){
        System.out.println(itemId);
        return null;
    }

    @GetMapping("/updateGoodsMsg")
    public JsonResult updateGoodsMsg(@RequestBody SimpleUpdateGoodsBo updateGoodsBo){
        System.out.println(updateGoodsBo);
        return null;
    }

    @GetMapping("/deleteGoodsMsg")
    public JsonResult deleteGoodsMsg(@RequestParam String goodsId){
        return null;
    }

    @PostMapping("/addGoods")
    public JsonResult addGoods(@RequestBody ItemBo formData){
        System.out.println(formData);
        int i = adminService.addGoods(formData);

        return null;
    }

    @PostMapping("/push")
    public void push(@RequestBody Object formData){
        System.out.println(formData);
    }
}
