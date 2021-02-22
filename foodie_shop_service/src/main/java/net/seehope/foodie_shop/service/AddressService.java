package net.seehope.foodie_shop.service;

import net.seehope.foodie_shop.bo.AddressBo;
import net.seehope.foodie_shop.bo.UpdateAddressBo;
import net.seehope.foodie_shop.vo.UserAddressVo;

import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 20:25
 */
public interface AddressService {
    /**
     * 为当前用户添加收货地址
     * @param addressBo 需要添加的地址数据
     * @return
     */
    Integer addReceivingAddress(AddressBo addressBo);

    /**
     * 获取当前用户的收货地址
     * @param userId 当前用户的id
     * @return
     */
    List<UserAddressVo> getReceivingAddressList(String userId);

    /**
     * 更新当前用户的指定收货地址
     * @param updateAddressBo
     * @return
     */
    Integer updateReceivingAddress(UpdateAddressBo updateAddressBo);

    /**
     * 删除当前用户指定的某一个收货地址
     * @param addressId 当前用户需要删除的地址id
     * @return
     */
    Integer deleteReceivingAddress(String addressId);

    /**
     * 把某个地址设置成默认地址，并且把原来的默认收货地址设置为非默认收货地址
     * @param addressId
     * @param userId
     * @return
     */
    Integer setReceivingAddressToDefault(String addressId,String userId);
}
