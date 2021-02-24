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
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/20 17:36
 *
 * 验证验证码是否正确
 */

public class ValidateCodeFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(ValidateCodeFilter.class);

    private AuthenticationFailureHandler failureHandler;

    private Set<String> processingUrl = new HashSet<String>();

    private List < ValidateCodeProcessor > validateCodeProcessors;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request, response);
        for (ValidateCodeProcessor validateCodeProcessor : validateCodeProcessors) {
            if (validateCodeProcessor.isNeedDoValidate(servletWebRequest)){
                try {
                    validateCodeProcessor.doValidate(servletWebRequest);
                    filterChain.doFilter(request,response);
                    return;
                }catch (DoValidateException e){
                    failureHandler.onAuthenticationFailure(request,response,e);
                }
            }
        }
        filterChain.doFilter(request,response);
    }

    public AuthenticationFailureHandler getFailureHandler() {
        return failureHandler;
    }

    public void setFailureHandler(AuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }

    public Set<String> getProcessingUrl() {
        return processingUrl;
    }

    public void setProcessingUrl(Set<String> processingUrl) {
        this.processingUrl = processingUrl;
    }

    public List<ValidateCodeProcessor> getValidateCodeProcessors() {
        return validateCodeProcessors;
    }

    public void setValidateCodeProcessors(List<ValidateCodeProcessor> validateCodeProcessors) {
        this.validateCodeProcessors = validateCodeProcessors;
    }
}
