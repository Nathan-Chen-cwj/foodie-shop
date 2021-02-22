package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.bo.AddressBo;
import net.seehope.foodie_shop.bo.UpdateAddressBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.pojo.UserAddress;
import net.seehope.foodie_shop.vo.UserAddressVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface UserAddressMapper extends tk.mybatis.mapper.common.Mapper<UserAddress> {
    public Integer addReceivingAddress(AddressBo addressBo);

    public List<UserAddressVo> getReceivingAddressList(String userId);

    public Integer updateReceivingAddress(UpdateAddressBo addressBo);

    public Integer deleteReceivingAddressByAddressId(String addressId);

    public Integer setReceivingAddressToDefault(@RequestParam("addressId") String addressId,@RequestParam("userId") String userId);

    public Integer setReceivingAddressNotToDefault(String addressId);
}




