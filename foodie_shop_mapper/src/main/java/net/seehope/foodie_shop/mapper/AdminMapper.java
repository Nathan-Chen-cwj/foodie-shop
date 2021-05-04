package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.bo.AdminBo;
import net.seehope.foodie_shop.bo.ImgUrlBo;
import net.seehope.foodie_shop.bo.ItemBo;
import net.seehope.foodie_shop.bo.SimpleUpdateGoodsBo;
import net.seehope.foodie_shop.pojo.Admin;
import net.seehope.foodie_shop.vo.*;

import java.util.List;

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

    /**
     * 通过管理员id查询管理员信息
     * @param id
     * @return
     */
    public Admin queryAdminById(String id);

    /**
     * 获取收入、订单数、商品数、用户数
     * @return
     */
    public ConsoleDataVo getConsoleData();

    /**
     * 获取所有商品列表
     * @return
     */
    public List<GoodListVo> getAllGoodsList();

    /**
     * 获取所有用户列表
     * @return
     */
    public List<UserListVo> getAllUsersList();

    /**
     * 获取所有管理员列表
     * @return
     */
    public List<Admin> getAllAdminsList();

    /**
     * 获取所有订单列表
     * @return
     */
    public List<OrderListVo> getAllOrdersList();

    /**
     * 添加商品，系列操作
     * @param itemBo
     * @return
     */
    public int addItem(ItemBo itemBo);

    /**
     * 添加商品，系列操作
     * @param itemBo
     * @return
     */
    public int addItemParam(ItemBo itemBo);

    /**
     * 添加商品，系列操作
     * @param itemBo
     * @return
     */
    public int addItemImg(ImgUrlBo itemBo);

    /**
     * 添加商品，系列操作
     * @param itemBo
     * @return
     */
    public int addItemSpec(ItemBo itemBo);

    /**
     * 商品上架
     * @param goodsBoList
     * @return
     */
    public int putGoodsOnSell(String goodsBoList);

    /**
     * 商品下架
     * @param goodsBoList
     * @return
     */
    public int offGoodsDownSell(String goodsBoList);

    /**
     * 简单更新商品信息
     * @param simpleUpdateGoodsBo
     * @return
     */
    public int updateGoodsMsgInItemsSpec(SimpleUpdateGoodsBo simpleUpdateGoodsBo);
    /**
     * 简单更新商品信息
     * @param simpleUpdateGoodsBo
     * @return
     */
    public int updateGoodsMsgInItems(SimpleUpdateGoodsBo simpleUpdateGoodsBo);

    /**
     * 删除商品系列操作
     * @param itemId
     * @return
     */
    public int deleteGoodsMsgInItemTable(String itemId);

    /**
     * 删除商品系列操作
     * @param itemId
     * @return
     */
    public int deleteGoodsMsgInItemParamTable(String itemId);

    /**
     * 删除商品系列操作
     * @param itemId
     * @return
     */
    public int deleteGoodsMsgInItemImgTable(String itemId);

    /**
     * 删除商品系列操作
     * @param itemId
     * @return
     */
    public int deleteGoodsMsgInItemSpecTable(String itemId);
}
