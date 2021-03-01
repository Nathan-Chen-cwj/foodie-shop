package net.seehope.foodie_shop.authorized;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/1 21:27
 */
public interface AuthorizedConfigProvider {
    /**
     * 授权提供方法
     * 如果当前授权配置子模块，有对any request的配置，那么返回为真，否则返回假
     * @param config
     * @return true/false
     */
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);
}
