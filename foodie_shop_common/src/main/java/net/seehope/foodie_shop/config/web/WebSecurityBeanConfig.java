package net.seehope.foodie_shop.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 10:53
 * 配置spring 提供的数据加密功能
 */
@Configuration
public class WebSecurityBeanConfig {

    /**
     * 数据加密功能
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
