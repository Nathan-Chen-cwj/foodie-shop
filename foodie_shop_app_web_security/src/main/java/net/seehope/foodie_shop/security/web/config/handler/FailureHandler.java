package net.seehope.foodie_shop.security.web.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.seehope.foodie_shop.common.ProjectProperties;
import net.seehope.foodie_shop.enums.LoginType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/20 11:20
 *
 * 认证失败处理器
 *
 * exception 什么异常导致认证失败
 *
 */
@Component
public class FailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private ProjectProperties properties;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (LoginType.json.equals(properties.getBrowser().getLoginType())){
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(exception.getMessage()));
            exception.printStackTrace();
        }else {
            //否则直接调用父类的逻辑直接重定向
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
