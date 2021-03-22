package net.seehope.foodie_shop.service.impl;

import net.seehope.foodie_shop.bo.AdminBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.exception.LogOutException;
import net.seehope.foodie_shop.exception.LoginException;
import net.seehope.foodie_shop.exception.RegisterException;
import net.seehope.foodie_shop.mapper.AdminMapper;
import net.seehope.foodie_shop.pojo.Admin;
import net.seehope.foodie_shop.service.AdminService;
import net.seehope.foodie_shop.vo.AdminVo;
import net.seehope.foodie_shop.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/18 21:43
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean queryUserNameIsExist(String username) {
        if (adminMapper.queryAdminNameIsExist(username)==null){
            return false;
        }
        throw new RegisterException("该用户名已被注册！");
    }

    @Override
    public boolean insertUser(AdminBo adminBo) {
        return false;
    }

    @Override
    public AdminVo doesUsernameAndPasswordMatch(AdminBo adminBo) {
        AdminVo adminVo = adminMapper.queryUserPasswordByUsername(adminBo.getUsername());
        if( passwordEncoder.matches(adminVo.getPassword(),adminVo.getPassword())){
            return adminVo;
        }
        if( adminVo.getPassword().equals(adminVo.getPassword())){
            return adminVo;
        }
        throw new LoginException("用户名或密码不正确！");
    }

    @Override
    public Admin queryAdminById(String id) {
        Admin admin = adminMapper.queryAdminById(id);
        if (admin!=null){
            return admin;
        }
        throw new LogOutException("请先登陆！");
    }


}
