package net.seehope.foodie_shop.validate;

import net.seehope.foodie_shop.common.ProjectProperties;
import net.seehope.foodie_shop.exception.DoValidateException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/20 17:36
 *
 * 验证验证码是否正确
 */

public class ValidateCodeFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(ValidateCodeFilter.class);

    private ProjectProperties properties;

    public ProjectProperties getProperties() {
        return properties;
    }

    public void setProperties(ProjectProperties properties) {
        this.properties = properties;
    }

    /**
     * 使用该方法便于后期使用redis改造
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();


    private AuthenticationFailureHandler failureHandler;

    public AuthenticationFailureHandler getFailureHandler() {
        return failureHandler;
    }

    public void setFailureHandler(AuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 如果是登陆认证相关才做处理
        if (StringUtils.equals(request.getRequestURI(),properties.getBrowser().getLoginProcessingUrl()) &&
        StringUtils.equalsIgnoreCase(request.getMethod(),"POST")){
            try {
                doValidate(new ServletWebRequest(request, response));
                filterChain.doFilter(request,response);
            }catch (AuthenticationException e){
                failureHandler.onAuthenticationFailure(request,response,e);
                return;
            }
        }else {
            filterChain.doFilter(request,response);
        }
    }

    public void doValidate(ServletWebRequest request) throws ServletRequestBindingException{
        ValidateCode codeInSession = (ValidateCode) sessionStrategy.getAttribute(request, ValidateCodeController.IMAGE_VALIDATE_CODE_IN_SESSION);
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "validateCode");
        if(StringUtils.isBlank(codeInSession.getCode())|| codeInSession.getCode()==null){
            throw new DoValidateException("系统无验证码，请访问登陆页面");
        }
        if (StringUtils.isBlank(codeInRequest) || codeInRequest==null){
            throw new DoValidateException("请求中无验证码,请填写验证码");
        }
        if (codeInSession.isExpire()){
            throw new DoValidateException("验证码已过期，请刷新后再尝试");
        }
        if (!StringUtils.equalsAnyIgnoreCase(codeInRequest,codeInSession.getCode())){
            throw new DoValidateException("验证码不匹配，请重新输入");
        }
        sessionStrategy.removeAttribute(request, ValidateCodeController.IMAGE_VALIDATE_CODE_IN_SESSION);
    }
}
