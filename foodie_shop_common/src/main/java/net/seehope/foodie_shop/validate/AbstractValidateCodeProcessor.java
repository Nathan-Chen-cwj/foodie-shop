package net.seehope.foodie_shop.validate;

import net.seehope.foodie_shop.common.ProjectConstant;
import net.seehope.foodie_shop.common.ProjectProperties;
import net.seehope.foodie_shop.exception.DoValidateException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/22 21:44
 *
 * 验证码处理器抽象类
 *
 * <C extends ValidateCode> 表示返回的处理结果是ValidateCode的任意子类
 *     C 表示子类返回的具体code类型
 *     ValidateCode所有验证码的父类
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerator;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 引入AntPathMatcher
     * 进行地址匹配 让过滤器可以处理
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();


    @Override
    public void createValidateCode(ServletWebRequest request) throws IOException {
        C code = generateValidateCode();
        saveValidateCode(request,code);
        sendValidateCode(request,code);
    }

    @Override
    public void doValidate(ServletWebRequest request) throws ServletRequestBindingException {
        ValidateCode codeInSession = (ValidateCode) sessionStrategy.getAttribute(request,
                StringUtils.upperCase(getRealValidateCodeProcessorType())
                        + ProjectConstant.VALIDATE_CODE_IN_SESSION_SUFFIX);
        String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), getRealValidateCodeProcessorType()+"ValidateCode");
        if(StringUtils.isBlank(codeInSession.getCode())){
            throw new DoValidateException("系统无验证码，请访问登陆页面");
        }
        if (StringUtils.isBlank(codeInRequest) && codeInRequest == null){
            throw new DoValidateException("请求中无验证码,请填写验证码");
        }
        if (codeInSession.isExpire()){
            throw new DoValidateException("验证码已过期，请刷新后再尝试");
        }
        if (!StringUtils.equalsAnyIgnoreCase(codeInRequest,codeInSession.getCode())){
            throw new DoValidateException("验证码不匹配，请重新输入");
        }
        sessionStrategy.removeAttribute(request, StringUtils.upperCase(getRealValidateCodeProcessorType()) + ProjectConstant.VALIDATE_CODE_IN_SESSION_SUFFIX);
    }

    /**
     * 生产验证码
     * @return 返回的验证码 根据子类实现不同有不同的返回，所以采用泛型
     */
    public C generateValidateCode(){
        Set<String> keys = validateCodeGenerator.keySet();
        for (String key : keys) {
            if (StringUtils.containsIgnoreCase(key,getRealValidateCodeProcessorType())){
                return (C)validateCodeGenerator.get(key).generatorValidateCode();
            }
        }
        return null;
    }

    /**
     * 保存验证码，用于校验
     * @param request 请求、响应
     * @param code 验证码
     */
    public void saveValidateCode(ServletWebRequest request,C code){
        sessionStrategy.setAttribute(request,StringUtils.upperCase(getRealValidateCodeProcessorType())
                + ProjectConstant.VALIDATE_CODE_IN_SESSION_SUFFIX,code);
    }

    /**
     *
     * 发送验证码
     * @param request 请求、响应
     * @param code 需要发送的验证码
     * @throws IOException
     */
    public abstract void sendValidateCode(ServletWebRequest request,C code) throws IOException;

    /**
     * 获取真正的验证码处理器类型
     * @return 子类返回的处理器类型
     */
    public abstract String getRealValidateCodeProcessorType();

    /**
     * 判断哪个子类实现需要做验证
     * @param request request&response
     * @return true/false
     */
    @Override
    public boolean isNeedDoValidate(ServletWebRequest request){
        String[] urls = StringUtils.splitByWholeSeparatorPreserveAllTokens(getProcessingUrl(),",");
        for (String url:urls) {
            if (antPathMatcher.match(url,request.getRequest().getRequestURI())){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取子类的实际验证处理地址
     * @return
     */
    public abstract String getProcessingUrl();
}
