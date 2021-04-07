package net.seehope.foodie_shop.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.seehope.foodie_shop.bo.UserBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.common.ProjectProperties;
import net.seehope.foodie_shop.mapper.UsersMapper;

import net.seehope.foodie_shop.pojo.Users;
import net.seehope.foodie_shop.service.UserService;
import net.seehope.foodie_shop.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.mayanjun.code.idworker.IdWorker;
import org.mayanjun.code.idworker.IdWorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 11:08
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ProjectProperties properties;

    @Override
    public JsonResult queryUserNameIsExist(String username) {
        //使用该用户名在数据库查到数据
        if (usersMapper.queryUserNameIsExist(username) != null){
            return JsonResult.err("账户已存在");
        }
        return JsonResult.isOk("账户可注册");
    }

    /**
     * 用户注册核心代码
     * @param userBo
     * @return
     */
    @Override
    public JsonResult insertUser(UserBo userBo) {
        if (userBo.getPassword().equals(userBo.getConfirmPassword())){
            //密码加密
            String password = passwordEncoder.encode(userBo.getPassword());
            //更新bo密码
            userBo.setPassword(password);
            // 生成用户id
            IdWorker idworker = IdWorkerFactory.create();
            long id = idworker.nextId();
            userBo.setId(String.valueOf(id));
            //创建日期
            userBo.setCreateTime(new Date());
            userBo.setUpdateTime(new Date());
            // 默认头像信息
            userBo.setFace("http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png");
            // 判断是否注册入户成功
            if(usersMapper.insertUser(userBo).equals(null)){

                return JsonResult.err("系统异常，注册失败，请稍后再试");
            }else {
                // 登录
                return JsonResult.isOk(usersMapper.queryUserByUsernameAndPassword(userBo.getUsername(),password));
            }
        }else {
            return JsonResult.err("两次输入的密码不一致！请重新输入");
        }
    }

    /**
     * 用户登陆实现方法
     * @param userBo
     * @return
     */
    @Override
    public JsonResult doesUsernameAndPasswordMatch(UserBo userBo) {
        UserVo userVo = usersMapper.queryUserPassword(userBo.getUsername());
        if(userVo==null || !passwordEncoder.matches(userBo.getPassword(),userVo.getPassword())){
            return JsonResult.err("账号名或密码错误");
        }
        return JsonResult.isOk(userVo);
    }

    @Override
    public JsonResult queryMobileDoesExist(String mobile) {
        Users users = usersMapper.queryMobileDoesExist(mobile);
        if (users == null){
            return JsonResult.isOk("该手机号码可以使用！");
        }
        return JsonResult.err("该手机号码已被注册，请核对后再输入！");
    }

    @Override
    public JsonResult queryEmailDoesExist(String email) {
        Users users = usersMapper.queryEmailDoesExist(email);
        if (users == null){
            return JsonResult.isOk("该邮箱可以使用！");
        }
        return JsonResult.err("该邮箱已被注册，请核对后再输入！");
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //进行登陆路径分拣，来调用具体的登陆验证逻辑
        if(StringUtils.equals(properties.getSmsValidateCodeProperties().getSmsValidateCodeProcessingUrl(),request.getRequestURI())){
            log.debug("security登陆表单中的用户手机号码{}",username);
            Users users = new Users();
            users.setMobile(username);
            return getUser(users);
        }else {
            log.debug("security登陆表单中的用户名{}",username);
            Users users = new Users();
            users.setUsername(username);
            return getUser(users);
        }
    }

    public User getUser(Users users){
        List<Users> usersList = usersMapper.select(users);
        if (usersList.size()!=1){
            log.error("登陆异常，一共查询了{}条数据,与预期不同",usersList.size());
            throw new RuntimeException("该用户尚未注册!请注册后登陆!");
        }else {
            Users loginUser = usersList.get(0);
            return new User(loginUser.getUsername(), loginUser.getPassword(), true, true, true, true,
                    AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN"));
        }
    }
}
