package net.seehope.foodie_shop.service;

import net.seehope.foodie_shop.bo.AdminBo;
import net.seehope.foodie_shop.pojo.Admin;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/15 21:57
 */
public interface AdminService {
    /**
     * 查询用户名是否已存在
     * @param username
     * @return
     */
    public boolean queryUserNameIsExist(String username);

    /**
     * 插入新用户
     * @param adminBo
     * @return
     */
    public boolean insertUser(AdminBo adminBo);

    /**
     * 校验用户名和密码是否一致
     * @param adminBo
     * @return
     */
    public boolean doesUsernameAndPasswordMatch(AdminBo adminBo);
}
