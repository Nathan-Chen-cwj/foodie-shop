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

    private String swagger = "/swagger-ui/*";
    /**
     * 默认登陆响应返回json
     */
    private LoginType loginType = LoginType.json;

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

    public String getSwagger() {
        return swagger;
    }

    public void setSwagger(String swagger) {
        this.swagger = swagger;
    }
}
