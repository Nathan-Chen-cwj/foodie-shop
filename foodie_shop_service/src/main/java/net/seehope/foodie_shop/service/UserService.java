package net.seehope.foodie_shop.service;

import net.seehope.foodie_shop.bo.UserBo;
import net.seehope.foodie_shop.common.JsonResult;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 11:06
 */
public interface UserService {
    /**
     * 查询用户名是否已存在
     * @param username
     * @return
     */
    public JsonResult queryUserNameIsExist(String username);

    /**
     * 插入新用户
     * @param userBo
     * @return
     */
    public JsonResult insertUser(UserBo userBo);

    /**
     * 校验用户名和密码是否一致
     * @param userBo
     * @return
     */
    public JsonResult doesUsernameAndPasswordMatch(UserBo userBo);

    /**
     * 查询手机号码是否已存在
     * @param mobile
     * @return
     */
    public JsonResult queryMobileDoesExist(String mobile);

    /**
     * 查询手机号码是否已存在
     * @param email
     * @return
     */
    public JsonResult queryEmailDoesExist(String email);

}
