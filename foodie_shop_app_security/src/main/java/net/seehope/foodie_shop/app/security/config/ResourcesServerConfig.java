package net.seehope.foodie_shop.app.security.config;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Component;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/7 15:29
 *
 * oauth2 认证资源中心配置类
 * EnableResourceServer 标记为认证服务资源中心
 */
@Component
@EnableResourceServer
public class ResourcesServerConfig {
}
