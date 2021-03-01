package net.seehope.foodie_shop.authorized;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/1 21:34
 *
 * 进行AuthorizeConfigProvider管理
 */
@Slf4j
@Configuration
public class DefaultAuthorizedConfigManager implements AuthorizedConfigManager{
    /**
     * 获取当前工程中的所有AuthorizeConfigProvider
     */
    @Autowired
    private List<AuthorizedConfigProvider> authorizedConfigProviderList;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        int flag = 0;
        for (AuthorizedConfigProvider authorizedConfigProvider : authorizedConfigProviderList) {
            boolean current = authorizedConfigProvider.config(config);
            if (current==true){
                flag++;
                log.info("当前系统中已经有对anyrequest的配置，配置该参数的类名为{}", authorizedConfigProvider.getClass().getName());
            }
            if (flag>1){
                throw new RuntimeException("重复的anyrequest的配置，当前系统中已经有对anyrequest的配置，配置该参数的类名为"+ authorizedConfigProvider.getClass().getName());
            }
            if(flag==0){
                log.info("未对anyrequest进行配置,已在{}自动配置",DefaultAuthorizedConfigManager.class);
                config.anyRequest().authenticated();
            }
        }
    }
}
