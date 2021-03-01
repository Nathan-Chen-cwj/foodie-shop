package net.seehope.foodie_shop.validate.config;

import net.seehope.foodie_shop.authentication.sms.SmsCodeAuthenticationConfig;
import net.seehope.foodie_shop.common.ProjectConstant;
import net.seehope.foodie_shop.common.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/1 17:43
 *
 * 配置表单登陆处理相关配置
 */
@Configuration
public class FormAuthenticationConfig {

    @Autowired
    private ProjectProperties properties;

    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;


    public void configure(HttpSecurity http) throws Exception{
        http.formLogin()
                //设置会覆盖登录表单所在的位置,可以是个控制器等
                .loginPage(ProjectConstant.LOGIN_PATH)
                //设置会覆盖登录表单请求的路径
                .loginProcessingUrl(properties.getBrowser().getLoginProcessingUrl())
                // 认证成功处理器
                .successHandler(successHandler)
                // 认证失败处理器
                .failureHandler(failureHandler);
    }
}
