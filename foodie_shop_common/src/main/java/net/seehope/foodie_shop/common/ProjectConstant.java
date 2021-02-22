package net.seehope.foodie_shop.common;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/19 23:04
 *
 * 工程常量
 */
public class ProjectConstant {
    /**
     * 当用户没有认证的时候跳转的路径
     * 跳转到控制器当中，判断请求是访问静态资源还是动态资源
     * 如果是静态资源，那么跳转到登录页面
     * 如果访问动态资源，那么返回json
     */
    public final static String LOGIN_PATH="/authentication/require";
}
