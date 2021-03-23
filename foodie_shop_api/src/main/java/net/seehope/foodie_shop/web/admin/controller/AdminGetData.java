package net.seehope.foodie_shop.web.admin.controller;

import net.seehope.foodie_shop.common.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    /**
     * 获取所有商品列表
     * @return
     */
    @GetMapping("/getAllGoods")
    public JsonResult getAllGoodsList(){
        return null;
    }

    /**
     * 获取所有用户列表
     * @return
     */
    @GetMapping("/getAllUsers")
    public JsonResult getAllUsersList(){
        return null;
    }

    /**
     * 获取所有管理员列表
     * @return
     */
    @GetMapping("/getAllAdmins")
    public JsonResult getAllAdminsList(){
        return null;
    }

    /**
     * 获取所有订单列表
     * @return
     */
    @GetMapping("/getAllOrders")
    public JsonResult getAllOrdersList(){
        return null;
    }

    /**
     * 获取所有收入
     * @return
     */
    @GetMapping("/getIncome")
    public JsonResult getIncome(){
        return null;
    }
}
