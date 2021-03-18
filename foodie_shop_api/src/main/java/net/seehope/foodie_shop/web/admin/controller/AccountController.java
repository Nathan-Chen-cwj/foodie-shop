package net.seehope.foodie_shop.web.admin.controller;

import net.seehope.foodie_shop.bo.AdminBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/12 13:44
 *
 * 管理员账户控制器
 */
@RestController
@RequestMapping("/admin")
public class AccountController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public JsonResult doesUsernameMatchPassword(@RequestBody AdminBo adminBo){
        return JsonResult.isOk(adminService.queryUserNameIsExist(adminBo.getUsername()));
    }

    @GetMapping("/findAdminName")
    public JsonResult doesUserNameIsExist(@RequestParam String adminName){
        return JsonResult.isOk(adminService.queryUserNameIsExist(adminName));
    }
}
