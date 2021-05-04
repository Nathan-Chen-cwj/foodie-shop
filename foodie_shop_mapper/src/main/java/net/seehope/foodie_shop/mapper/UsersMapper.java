package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.bo.UserBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.pojo.Users;
import net.seehope.foodie_shop.vo.UserOrdersVo;
import net.seehope.foodie_shop.vo.UserVo;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface UsersMapper extends tk.mybatis.mapper.common.Mapper<Users> {
    /**
     * 查询用户名是否以存在
     * @param username
     * @return
     */
    public Users queryUserNameIsExist(String username);

    /**
     * 插入用户
     * @param userBo
     * @return
     */
    public Integer insertUser(UserBo userBo);

    /**
     * 校验用户名和密码是否一致
     * @param username
     * @param password
     * @return
     */
    public UserVo queryUserByUsernameAndPassword(String username,String password);

    /**
     * 通过用户id获取所属用户的订单信息
     * @param id
     * @return
     */
    public List<UserOrdersVo> getOrdersById(String id);

    /**
     * 使用用户名查询用户密码
     * @param username
     * @return
     */
    public UserVo queryUserPassword(String username);

    /**
     * 查询手机号码是否已存在
     * @param mobile
     * @return
     */
    public Users queryMobileDoesExist(String mobile);

    /**
     * 查询手机号码是否已存在
     * @param email
     * @return
     */
    public Users queryEmailDoesExist(String email);
}




