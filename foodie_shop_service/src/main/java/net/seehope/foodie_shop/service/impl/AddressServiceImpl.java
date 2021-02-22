package net.seehope.foodie_shop.service.impl;

import net.seehope.foodie_shop.bo.AddressBo;
import net.seehope.foodie_shop.bo.UpdateAddressBo;
import net.seehope.foodie_shop.exception.AddReceivingAddressException;
import net.seehope.foodie_shop.exception.DeleteReceivingAddressException;
import net.seehope.foodie_shop.exception.SetReceivingAddressNotToDefaultException;
import net.seehope.foodie_shop.exception.UpdateReceivingAddressException;
import net.seehope.foodie_shop.mapper.UserAddressMapper;
import net.seehope.foodie_shop.service.AddressService;
import net.seehope.foodie_shop.vo.UserAddressVo;
import org.mayanjun.code.idworker.IdWorker;
import org.mayanjun.code.idworker.IdWorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 20:28
 *
 * 用户地址相关服务修改
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public Integer addReceivingAddress(AddressBo addressBo) {
        IdWorker idworker = IdWorkerFactory.create();
        long id = idworker.nextId();
        addressBo.setId(String.valueOf(id));
        addressBo.setCreatedTime(new Date());
        addressBo.setUpdatedTime(new Date());
        Integer addReceivingAddress = userAddressMapper.addReceivingAddress(addressBo);
        if (addReceivingAddress!= null){
            return addReceivingAddress;
        }
        throw new AddReceivingAddressException("系统异常，地址添加失败");
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    @Override
    public List<UserAddressVo> getReceivingAddressList(String userId) {
        return userAddressMapper.getReceivingAddressList(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    @Override
    public Integer updateReceivingAddress(UpdateAddressBo updateAddressBo) {
        updateAddressBo.setUpdatedTime(new Date());
        Integer updateReceivingAddress = userAddressMapper.updateReceivingAddress(updateAddressBo);
        if(updateReceivingAddress != null){
            return updateReceivingAddress;
        }
        throw new UpdateReceivingAddressException("系统异常，修改收货地址失败");
    }

    @Override
    public Integer deleteReceivingAddress(String addressId) {
        Integer deleteReceivingAddressByAddressId = userAddressMapper.deleteReceivingAddressByAddressId(addressId);
        if(deleteReceivingAddressByAddressId != null){
            return deleteReceivingAddressByAddressId;
        }
        throw new DeleteReceivingAddressException("系统异常，删除收货地址失败");
    }

    @Override
    public Integer setReceivingAddressToDefault(String addressId,String userId) {
        Integer setReceivingAddressToDefault = userAddressMapper.setReceivingAddressToDefault(addressId, userId);
        if(setReceivingAddressToDefault != null){
            // 把默认地址设置为非默认
            List<UserAddressVo> userAddressVos = userAddressMapper.getReceivingAddressList(userId);
            for(UserAddressVo userAddressVo : userAddressVos){
                if(Integer.parseInt(userAddressVo.getIsDefault()) == 1 && !userAddressVo.getId().equals(addressId)){
                    if(userAddressMapper.setReceivingAddressNotToDefault(userAddressVo.getId()) != null){
                        return setReceivingAddressToDefault;
                    }else {
                        throw new SetReceivingAddressNotToDefaultException("系统异常，修改默认地址为非默认地址失败");
                    }
                }
            }
            return setReceivingAddressToDefault;
        }
        throw new SetReceivingAddressNotToDefaultException("系统异常，修改为默认地址失败！");
    }
}
