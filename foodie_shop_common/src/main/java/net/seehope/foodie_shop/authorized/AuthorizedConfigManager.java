package net.seehope.foodie_shop.authorized;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/1 21:27
 *
 * 进行AuthorizeConfigProvider管理
 */
public interface AuthorizedConfigManager {
    /**
     * 授权提供方法
     * @param config
     */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);

}
