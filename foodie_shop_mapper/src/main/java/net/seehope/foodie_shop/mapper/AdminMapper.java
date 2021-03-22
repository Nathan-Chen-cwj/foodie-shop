package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.bo.AdminBo;
import net.seehope.foodie_shop.pojo.Admin;
import net.seehope.foodie_shop.vo.AdminVo;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/15 22:40
 */
public interface AdminMapper extends tk.mybatis.mapper.common.Mapper<Admin>{
    /**
     * 查询用户名是否以存在
     * @param username
     * @return
     */
    public Admin queryAdminNameIsExist(String username);

    /**
     * 插入用户
     * @param adminBo
     * @return
     */
    public Integer insertAdmin(AdminBo adminBo);

    /**
     * 校验用户名和密码是否一致
     * @param username
     * @param password
     * @return
     */
    public AdminVo queryUserByUsernameAndPassword(String username, String password);

    /**
     * 使用用户名查询用户密码
     * @param username
     * @return
     */
    public AdminVo queryUserPasswordByUsername(String username);

    public Admin queryAdminById(String id);
}
