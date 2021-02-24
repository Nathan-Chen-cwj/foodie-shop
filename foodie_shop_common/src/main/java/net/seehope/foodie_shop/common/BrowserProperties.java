package net.seehope.foodie_shop.common;

import net.seehope.foodie_shop.enums.LoginType;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/19 22:40
 *
 * 使用流览器访问的认证相关配置
 */
public class BrowserProperties {
    /**
     * 添加默认地址
     */
    private String loginPage="/demo-login.html";
    private String loginProcessingUrl="/authentication/form";

    private String swaggerUrl = "/swagger-ui.html/*";

    /**
     * 认证服务状态保留七天
     */
    private Integer tokenValiditySeconds=60*60*7;

    /**
     * 默认登陆响应返回json
     */
    private LoginType loginType = LoginType.json;

    public Integer getTokenValiditySeconds() {
        return tokenValiditySeconds;
    }

    public void setTokenValiditySeconds(Integer tokenValiditySeconds) {
        this.tokenValiditySeconds = tokenValiditySeconds;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getLoginProcessingUrl() {
        return loginProcessingUrl;
    }

    public void setLoginProcessingUrl(String loginProcessingUrl) {
        this.loginProcessingUrl = loginProcessingUrl;
    }

    public String getSwaggerUrl() {
        return swaggerUrl;
    }

    public void setSwaggerUrl(String swaggerUrl) {
        this.swaggerUrl = swaggerUrl;
    }
}
