package net.seehope.foodie_shop.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.seehope.foodie_shop.bo.UserBo;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.utils.CookieUtils;
import net.seehope.foodie_shop.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/1 17:53
 */
@RestController
@RequestMapping("/passport")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/usernameIsExist")
    public JsonResult queryUserNameIsExist(@RequestParam String username){
        return userService.queryUserNameIsExist(username);
    }

    @PostMapping("/regist")
    public JsonResult registerUser(@RequestBody UserBo userBo) throws JsonProcessingException {
        JsonResult jsonResult = userService.insertUser(userBo);
        Object user = jsonResult.getData();
        CookieUtils.setCookie(request,response,"user",objectMapper.writeValueAsString(user),68400,true);
        return jsonResult;
    }

    @PostMapping("/login")
    public JsonResult doesUsernameAndPasswordMatch(@RequestBody UserBo userBo) throws JsonProcessingException {
        JsonResult jsonResult = userService.doesUsernameAndPasswordMatch(userBo);
        Object user = jsonResult.getData();
        CookieUtils.setCookie(request,response,"user",objectMapper.writeValueAsString(user),68400,true);
        return jsonResult;
    }

    /**
     * 获取当前已登陆的用户的认证凭证
     * @param authentication 认证凭证
     * @return 认证凭证的json样式
     * 后续用jwt技术在客户端保留登陆凭证 签名认证防伪
     */
    @GetMapping("/me")
    public JsonResult getUserAuthentication(Authentication authentication){
        return JsonResult.isOk(authentication);
    }

    @PostMapping("/logout")
    public JsonResult logOut(@RequestParam String userId){
        CookieUtils.deleteCookie(request,response,"user");
        return JsonResult.isOk("logout success");
    }

    @GetMapping("/queryMobileDoesExist")
    public JsonResult queryMobileDoesExist(@RequestParam String mobile){
        return userService.queryMobileDoesExist(mobile);
    }

    @GetMapping("/queryEmailDoesExist")
    public JsonResult queryEmailDoesExist(@RequestParam String email){
        return userService.queryEmailDoesExist(email);
    }


}
