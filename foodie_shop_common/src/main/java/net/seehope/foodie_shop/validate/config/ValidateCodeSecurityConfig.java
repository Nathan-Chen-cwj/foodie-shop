package net.seehope.foodie_shop.validate.config;

import net.seehope.foodie_shop.validate.ValidateCodeFilter;
import net.seehope.foodie_shop.validate.ValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/1 17:26
 *
 * 验证码验证逻辑配置类
 */
@Configuration
public class ValidateCodeSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Autowired
    private List<ValidateCodeProcessor> validateCodeProcessors;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        //添加过滤器
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setFailureHandler(failureHandler);
        validateCodeFilter.afterPropertiesSet();
        validateCodeFilter.setValidateCodeProcessors(validateCodeProcessors);
    }
}
