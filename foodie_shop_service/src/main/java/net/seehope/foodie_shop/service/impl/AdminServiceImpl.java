package net.seehope.foodie_shop.service.impl;

import com.github.pagehelper.PageHelper;
import net.seehope.foodie_shop.bo.AdminBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.exception.LogOutException;
import net.seehope.foodie_shop.exception.RegisterException;
import net.seehope.foodie_shop.mapper.AdminMapper;
import net.seehope.foodie_shop.pojo.Admin;
import net.seehope.foodie_shop.service.AdminService;
import net.seehope.foodie_shop.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public JsonResult doesUsernameAndPasswordMatch(AdminBo adminBo,String verCodeInSession) {
        if (adminBo.getVerCode() == null){
                return JsonResult.err("验证码不能为空！");
            }
        if (!adminBo.getVerCode().equals(verCodeInSession)) {
            return JsonResult.err("验证码错误！");
        }else {
            AdminVo adminVo = adminMapper.queryUserPasswordByUsername(adminBo.getUsername());
            if(adminVo!=null){
                if( adminBo.getPassword().equals(adminVo.getPassword())){
                    return JsonResult.isOk(adminVo);
                }
                return JsonResult.err("密码或用户名错误！");
            }else {
                return JsonResult.err("密码或用户名错误！");
            }
        }
    }

    @Override
    public Admin queryAdminById(String id) {
        Admin admin = adminMapper.queryAdminById(id);
        if (admin!=null){
            return admin;
        }
        throw new LogOutException("请先登陆！");
    }

    @Override
    public List<GoodsListVo> getAllGoodsList(Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<GoodsListVo> allGoodsList = adminMapper.getAllGoodsList();
        return allGoodsList;
    }

    @Override
    public List<UsersVo> getAllUsersList(Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<UsersVo> allUsersList = adminMapper.getAllUsersList();
        return allUsersList;
    }

    @Override
    public List<Admin> getAllAdminsList(Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Admin> allAdminsList = adminMapper.getAllAdminsList();
        return allAdminsList;
    }

    @Override
    public List<OrdersVo> getAllOrdersList(Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<OrdersVo> allOrdersList = adminMapper.getAllOrdersList();
        return allOrdersList;
    }

    @Override
    public ConsoleDataVo getConsoleData() {
        return adminMapper.getConsoleData();
    }


}
