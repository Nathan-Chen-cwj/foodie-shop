package net.seehope.foodie_shop.security.web.config;

import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.common.ProjectConstant;
import net.seehope.foodie_shop.common.ProjectProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Version 1.0
 * @Author vessel
 * @Date 2021/2/9 18:24
 *
 * 认证登陆控制器
 */
@RestController
public class LoginController {

    /**
     * 处理web端请求
     * HttpStatus.UNAUTHORIZED 未经认证状态
     * produces 判断请求形式
     */
//    @RequestMapping(produces = "text/html",path = "/authentication/require")
//    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
//    public JsonResult requireAuthentication(){
//        return null;
//    }

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 用于获取用户第一次访问地址
     */
    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ProjectProperties properties;

    /**
     * 重定向策略工具类
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 检测用户是否已进行登录认证
     * @return json result
     */
    @RequestMapping(path = ProjectConstant.LOGIN_PATH)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public JsonResult requireAuthentication() throws IOException {
        //获取到用户第一次访问的地址
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        logger.info("get savedRequest {}",savedRequest);
        if(savedRequest != null){
            String redirectUrl = savedRequest.getRedirectUrl();
            logger.info("用户第一次登陆的路径{}",redirectUrl);
            /*
                进行一个登陆判断分拣，要是用户未经认证就先指引用户进行认证
                要是是网站请求就重定向到登陆页面
             */
            if (StringUtils.endsWith(redirectUrl,".html")){
                redirectStrategy.sendRedirect(request,response,properties.getBrowser().getLoginPage());
            }
            // 否则返回一个未认证的json数据，但是由于没有app数据，只能再一次重定向来实现
            redirectStrategy.sendRedirect(request,response,properties.getBrowser().getLoginPage());
        }
        return JsonResult.errAuthorize("访问的服务需要身份认证，请登陆后再访问");
    }
}
