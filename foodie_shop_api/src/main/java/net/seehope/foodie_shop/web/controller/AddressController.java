package net.seehope.foodie_shop.web.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.seehope.foodie_shop.bo.AddressBo;
import net.seehope.foodie_shop.bo.UpdateAddressBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 17:40
 *
 * 结算页面地址管理
 */
@Tag(name = "address",description = "结算页面地址列表显示")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 引入swagger前端显示测试框架
     * Tag标签 实现前后端分离提供自动的接口文档，该标签的内容用于在swagger框架显示
     * @param addressBo 用户添加收货地址需要的参数
     * @return 返回rest-ful 风格
     * 添加收货地址接口
     */
    @Parameter(name = "addressBo",description = "用户添加收货地址需要的参数")
    @Tag(name = "add",description = "添加收货地址")
    @PostMapping("/add")
    public JsonResult addReceivingAddress(@RequestBody AddressBo addressBo){
        return JsonResult.isOk(addressService.addReceivingAddress(addressBo));
    }

    /**
     * 显示当前用户全部收货地址接口
     * @param userId 用户id
     * @return 返回json result
     */
    @Parameter(name = "userId",description = "用户id")
    @Tag(name = "list",description = "显示登陆用户的全部收货地址")
    @PostMapping("/list")
    public JsonResult getReceivingAddressList(@RequestParam String userId){
        return JsonResult.isOk(addressService.getReceivingAddressList(userId));
    }

    /**
     * 更新用户收货地址
     * @param updateAddressBo 需要更新的收货地址
     * @return JsonResult
     */
    @Parameter(name = "updateAddressBo",description = "需要更新的收货地址的参数")
    @Tag(name = "update",description = "显示登陆用户的全部收货地址")
    @PostMapping("/update")
    public JsonResult updateReceivingAddress(@RequestBody UpdateAddressBo updateAddressBo){
        return JsonResult.isOk(addressService.updateReceivingAddress(updateAddressBo));
    }

    /**
     * 删除指定收货地址
     * @param addressId 收货地址的id
     * @return JsonResult
     */
    @Parameter(name = "addressId",description = "需要删除的地址的id")
    @Tag(name = "delete",description = "删除该收货地址")
    @PostMapping("/delete")
    public JsonResult deleteReceivingAddressByAddressId(@RequestParam String addressId){
        return JsonResult.isOk(addressService.deleteReceivingAddress(addressId));
    }

    /**
     * 设置默认地址
     * @param addressId 地址id
     * @param userId 用户id
     * @return JsonResult
     */
    @Parameters(value = {
            @Parameter (name = "addressId",description = "需要设置为默认的地址的id"),
            @Parameter(name = "userId",description = "归属于哪个用户")}
    )
    @Tag(name = "setDefalut",description = "更改设置用户默认收货地址")
    @PostMapping("/setDefalut")
    public JsonResult setReceivingAddressToDefault(@RequestParam String addressId,String userId){
        return JsonResult.isOk(addressService.setReceivingAddressToDefault(addressId,userId));
    }

}
