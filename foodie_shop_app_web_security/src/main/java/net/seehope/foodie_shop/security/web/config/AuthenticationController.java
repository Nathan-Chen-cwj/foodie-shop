//package net.seehope.foodie_shop.security.web.config;
//
//import net.seehope.foodie_shop.common.ProjectProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @Version 1.0
// * @Author NathanChen
// * @Date 2021/2/22 11:42
// */
//@Controller
//@RequestMapping("/authentication")
//public class AuthenticationController {
//
//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private HttpServletResponse response;
//
//    @Autowired
//    private ProjectProperties properties;
//
//    /**
//     * 重定向策略工具类
//     */
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    @RequestMapping("/require")
//    public void redirectLoginPage() throws IOException {
//        redirectStrategy.sendRedirect(request,response,properties.getBrowser().getLoginPage());
//    }
//}
