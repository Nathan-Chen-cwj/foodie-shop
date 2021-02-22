package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.bo.UserBo;
import net.seehope.foodie_shop.pojo.Users;
import net.seehope.foodie_shop.vo.UserVo;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface UsersMapper extends tk.mybatis.mapper.common.Mapper<Users> {
    public Users queryUserNameIsExist(String username);

    public Integer insertUser(UserBo userBo);

    public UserVo queryUserByUsernameAndPassword(String username,String password);

    public UserVo queryUserPassword(String username);
}




