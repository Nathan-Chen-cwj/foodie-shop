package net.seehope.foodie_shop.authorized;

import net.seehope.foodie_shop.common.ProjectConstant;
import net.seehope.foodie_shop.common.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/1 21:28
 */
@Configuration
public class DefaultAuthorizedConfigProvider implements AuthorizedConfigProvider {
    @Autowired
    private ProjectProperties properties;

    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        //请求符合该规则时，放行
        config.antMatchers(
                ProjectConstant.LOGIN_PAGE
                ,properties.getBrowser().getLoginPage(),
                properties.getBrowser().getLoginProcessingUrl(),
                ProjectConstant.LOGIN_PATH,
                "/css/bootstrap.min.css",
                "/css/style.css",
                "css/unicons.css",
                properties.getBrowser().getSwaggerUrl(),
                ProjectConstant.VALIDATE_CODE_URL_PREFIX+"*",
                properties.getSmsValidateCodeProperties().getSmsValidateCodeProcessingUrl()).permitAll();
        return false;
    }
}
