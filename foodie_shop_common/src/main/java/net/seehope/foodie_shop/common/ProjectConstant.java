package net.seehope.foodie_shop.common;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/19 23:04
 *
 * 工程常量
 */
public class ProjectConstant {

    public final static String LOGIN_PAGE="/demo-login.html";
    /**
     * 当用户没有认证的时候跳转的路径
     * 跳转到控制器当中，判断请求是访问静态资源还是动态资源
     * 如果是静态资源，那么跳转到登录页面
     * 如果访问动态资源，那么返回json
     */
    public final static String LOGIN_PATH="/authentication/require";

    /**
     * 验证码生成方法共有前缀
     */
    public final static String VALIDATE_CODE_URL_PREFIX="/code/";

    /**
     * 验证码存储到session的后缀
     */
    public final static String VALIDATE_CODE_IN_SESSION_SUFFIX = "_VALIDATE_CODE_IN_SESSION";
    /**
     * 短信验证码默认处理地址
     */
    public final static String DEFAULT_SMS_VALIDATE_CODE_PROCESSING_URL = "/authentication/mobile";

}
