package net.seehope.foodie_shop.service;

import net.seehope.foodie_shop.bo.AdminBo;
import net.seehope.foodie_shop.bo.ItemBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.pojo.Admin;
import net.seehope.foodie_shop.vo.*;

import java.util.List;

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
     * @param verCodeInSession
     * @return
     */
    public JsonResult doesUsernameAndPasswordMatch(AdminBo adminBo, String verCodeInSession);

    /**
     * 通过用户id来查询用户信息
     * @param id
     * @return
     */
    public Admin queryAdminById(String id);

    /**
     * 获取所有商品列表
     * @return
     */
    public GoodsVo getAllGoodsList(Integer page, Integer pageSize);

    /**
     * 获取所有用户列表
     * @return
     */
    public UsersVo getAllUsersList(Integer page,Integer pageSize);

    /**
     * 获取所有管理员列表
     * @return
     */
    public List<Admin> getAllAdminsList(Integer page,Integer pageSize);

    /**
     * 获取所有订单列表
     * @return
     */
    public OrdersVo getAllOrdersList(Integer page,Integer pageSize);

    /**
     * 获取收入、订单数、商品数、用户数
     * @return
     */
    public ConsoleDataVo getConsoleData();

    /**
     * 添加商品
     * @param itemBo
     * @return
     */
    public int addGoods(ItemBo itemBo);
}
