package net.seehope.foodie_shop.service.impl;

import com.github.pagehelper.PageHelper;
import net.seehope.foodie_shop.bo.*;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.exception.LogOutException;
import net.seehope.foodie_shop.exception.RegisterException;
import net.seehope.foodie_shop.mapper.AdminMapper;
import net.seehope.foodie_shop.pojo.Admin;
import net.seehope.foodie_shop.service.AdminService;
import net.seehope.foodie_shop.vo.*;
import org.mayanjun.code.idworker.IdWorker;
import org.mayanjun.code.idworker.IdWorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/18 21:43
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;


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
    public GoodsVo getAllGoodsList(Integer page, Integer pageSize) {
        GoodsVo goodsVo = new GoodsVo();
        PageHelper.startPage(page, pageSize);
        List<GoodListVo> allGoodsList = adminMapper.getAllGoodsList();
        ConsoleDataVo consoleData = adminMapper.getConsoleData();
        goodsVo.setRecords(Integer.parseInt(consoleData.getItemsNum()));
        int records = allGoodsList.size();
        Double total = Math.ceil(records/pageSize);
        goodsVo.setRows(allGoodsList);

        goodsVo.setTotal(total);
        return goodsVo;
    }

    @Override
    public UsersVo getAllUsersList(Integer page,Integer pageSize) {
        UsersVo usersVo = new UsersVo();
        PageHelper.startPage(page, pageSize);
        List<UserListVo> allUsersList = adminMapper.getAllUsersList();
        Integer records = allUsersList.size();
        Double total = Math.ceil(records/pageSize);
        usersVo.setRows(allUsersList);
        ConsoleDataVo consoleData = adminMapper.getConsoleData();
        usersVo.setRecords(Integer.parseInt(consoleData.getUsersNum()));
        usersVo.setTotal(total);
        return usersVo;
    }

    @Override
    public List<Admin> getAllAdminsList(Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Admin> allAdminsList = adminMapper.getAllAdminsList();
        return allAdminsList;
    }

    @Override
    public OrdersVo getAllOrdersList(Integer page,Integer pageSize) {
        OrdersVo ordersVo = new OrdersVo();
        PageHelper.startPage(page, pageSize);
        List<OrderListVo> allOrdersList = adminMapper.getAllOrdersList();
        int records = allOrdersList.size();
        Double total = Math.ceil(records/pageSize);
        ordersVo.setRows(allOrdersList);
        ConsoleDataVo consoleData = adminMapper.getConsoleData();
        ordersVo.setRecords(Integer.parseInt(consoleData.getOrdersNum()));
        ordersVo.setTotal(total);
        return ordersVo;
    }

    @Override
    public ConsoleDataVo getConsoleData() {
        return adminMapper.getConsoleData();
    }


    @Override
    public int addGoods(ItemBo itemBo) {
        // 生成商品id
        IdWorker idworker = IdWorkerFactory.create();
        //把生成的id设置到itemBo中
        String itemId = String.valueOf(idworker.nextId());
        itemBo.setItemsId(itemId);
        itemBo.setItemsParamId(String.valueOf(idworker.nextId()));
        itemBo.setItemsSpecId(String.valueOf(idworker.nextId()));
        itemBo.setCreatedTime(new Date());
        itemBo.setUpdatedTime(new Date());
        List<ImgUrlBo> imgUrlBos = itemBo.getImgUrlBo();
        int imgUrlBosSize = imgUrlBos.size();
        for (int i = 0; i < imgUrlBosSize; i++) {
            ImgUrlBo imgUrlBo = imgUrlBos.get(i);
            imgUrlBo.setItemsImgId(String.valueOf(idworker.nextId()));
            String url = imgUrlBo.getUrl();
            if (url ==null){
                imgUrlBo.setUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4275574402,3927309638&fm=26&gp=0.jpg");
            }else{
                url="E:\\goodsImgUrl"+url;
            }
            imgUrlBo.setUrl(url);
            //设置主图
            if (i==0){
                imgUrlBo.setIsMain(1);
            }
            imgUrlBo.setSort(i);
            imgUrlBo.setItemId(itemId);
            imgUrlBo.setCreatedTime(new Date());
            imgUrlBo.setUpdatedTime(new Date());
            imgUrlBos.add(imgUrlBo);
            adminMapper.addItemImg(imgUrlBo);
        }
        try {
            adminMapper.addItem(itemBo);
            adminMapper.addItemParam(itemBo);
            adminMapper.addItemSpec(itemBo);
            return 1;
        }catch (Exception e){
            //强制手动事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int putGoodsOnSell(List<String> ids) {
        return adminMapper.putGoodsOnSell(ids);
    }

    @Override
    public int offGoodsDownSell(List<String> ids) {
        return adminMapper.offGoodsDownSell(ids);
    }

    @Override
    public int updateGoodsMsg(SimpleUpdateGoodsBo simpleUpdateGoodsBo) {
        return 0;
    }


}
