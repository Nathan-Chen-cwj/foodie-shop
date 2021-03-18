package net.seehope.foodie_shop.security.web.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.seehope.foodie_shop.common.ProjectProperties;
import net.seehope.foodie_shop.enums.LoginType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/20 11:21
 *
 * 认证成功处理器
 *
 * authentication 认证成功凭证
 */
//@Component
public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ProjectProperties properties;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //验证登陆方式
        if (LoginType.json.equals(properties.getBrowser().getLoginType())){
            //重写响应，把登陆凭证响应给前端
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else {
            //否则直接调用父类的逻辑直接重定向
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
