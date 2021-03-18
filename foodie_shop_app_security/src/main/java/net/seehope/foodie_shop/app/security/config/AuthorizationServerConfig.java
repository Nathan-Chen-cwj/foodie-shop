package net.seehope.foodie_shop.app.security.config;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.stereotype.Component;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/25 11:50
 *
 * 开启oauth2认证服务
 * EnableAuthorizationServer 使用该注解开启认证服务中心
 */
@Component
@EnableAuthorizationServer
public class AuthorizationServerConfig {
}
