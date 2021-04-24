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
    public JsonResult putGoodsOnSell(@RequestParam String itemSpecId){
        System.out.println(itemSpecId);
        int i = adminService.putGoodsOnSell(itemSpecId);
        if (i>0){
            return JsonResult.isOk("i");
        }
        return JsonResult.err("系统异常，设置失败");
    }

    @GetMapping("/offGoodsDownSell")
    public JsonResult offGoodsDownSell(@RequestParam String itemSpecId){
        System.out.println(itemSpecId);
        int i = adminService.offGoodsDownSell(itemSpecId);
        if (i>0){
            return JsonResult.isOk("i");
        }
        return JsonResult.err("系统异常设置失败");
    }

    @PostMapping("/updateGoodsMsg")
    public JsonResult updateGoodsMsg(@RequestBody SimpleUpdateGoodsBo updateGoodsBo){
        System.out.println(updateGoodsBo);
        return null;
    }

    /**
     * 删除商品信息，基本不使用，但是还是得有
     * @param itemId
     * @return
     */
    @GetMapping("/deleteGoodsMsg")
    public JsonResult deleteGoodsMsg(@RequestParam String itemId){
        int i = adminService.deleteGoodsMsg(itemId);
        if (i>0){
            return JsonResult.isOk("删除成功！");
        }
        return JsonResult.err("系统异常，删除失败");
    }

    @PostMapping("/addGoods")
    public JsonResult addGoods(@RequestBody ItemBo formData){
        System.out.println(formData);
        int i = adminService.addGoods(formData);
        if (i == 0){
            return JsonResult.err("系统异常，插入失败");
        }
        return JsonResult.isOk("插入成功！");
    }

}
