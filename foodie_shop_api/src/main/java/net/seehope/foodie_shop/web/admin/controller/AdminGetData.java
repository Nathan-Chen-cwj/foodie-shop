package net.seehope.foodie_shop.web.admin.controller;

import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/22 21:14
 * 管理员获取数据数据api
 */
@RestController
@RequestMapping("/getData")
public class AdminGetData {

    @Autowired
    private AdminService adminService;

    /**
     * 获取所有商品列表
     * @return
     */
    @GetMapping("/getAllGoods")
    public JsonResult getAllGoodsList(@RequestParam Integer page,Integer pageSize){
        return JsonResult.isOk(adminService.getAllGoodsList(page,pageSize));
    }

    /**
     * 获取所有用户列表
     * @return
     */
    @GetMapping("/getAllUsers")
    public JsonResult getAllUsersList(@RequestParam Integer page,Integer pageSize){
        return JsonResult.isOk(adminService.getAllUsersList(page,pageSize));
    }

    /**
     * 获取所有管理员列表
     * @return
     */
    @GetMapping("/getAllAdmins")
    public JsonResult getAllAdminsList(@RequestParam Integer page,Integer pageSize){
        return JsonResult.isOk(adminService.getAllAdminsList(page,pageSize));
    }

    /**
     * 获取所有订单列表
     * @return
     */
    @GetMapping("/getAllOrders")
    public JsonResult getAllOrdersList(@RequestParam Integer page,Integer pageSize){
        return JsonResult.isOk(adminService.getAllOrdersList(page,pageSize));
    }

    /**
     * 获取收入、订单数、商品数、用户数
     * @return
     */
    @GetMapping("/getConsoleData")
    public JsonResult getIncome(){
        return JsonResult.isOk(adminService.getConsoleData());
    }
}
