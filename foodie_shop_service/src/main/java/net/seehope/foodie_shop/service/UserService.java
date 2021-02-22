package net.seehope.foodie_shop.service;

import net.seehope.foodie_shop.bo.UserBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.vo.UserAddressVo;
import net.seehope.foodie_shop.vo.UserVo;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 11:06
 */
public interface UserService {

    public JsonResult queryUserNameIsExist(String username);

    public JsonResult insertUser(UserBo userBo);

    public JsonResult doesUsernameAndPasswordMatch(UserBo userBo);

}
