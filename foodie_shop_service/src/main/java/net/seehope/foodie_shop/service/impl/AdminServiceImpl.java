package net.seehope.foodie_shop.service.impl;

import net.seehope.foodie_shop.bo.AdminBo;
import net.seehope.foodie_shop.exception.RegisterException;
import net.seehope.foodie_shop.mapper.AdminMapper;
import net.seehope.foodie_shop.pojo.Admin;
import net.seehope.foodie_shop.service.AdminService;
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
    public boolean doesUsernameAndPasswordMatch(AdminBo adminBo) {
        return false;
    }
}
