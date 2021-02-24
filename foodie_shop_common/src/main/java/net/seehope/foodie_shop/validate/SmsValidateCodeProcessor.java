package net.seehope.foodie_shop.validate;

import net.seehope.foodie_shop.common.ProjectConstant;
import net.seehope.foodie_shop.common.ProjectProperties;
import net.seehope.foodie_shop.exception.LoginException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/22 21:49
 */
@Component
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode>{

    @Autowired
    private ProjectProperties properties;

    @Autowired
    private SmsValidateCodeSender smsValidateCodeSender;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public void createValidateCode(ServletWebRequest request) throws IOException, ServletRequestBindingException {
        super.createValidateCode(request);
    }

    @Override
    public void validatePerCheck(ServletWebRequest request) throws ServletRequestBindingException {
        SmsValidateCode codeInSession = (SmsValidateCode) sessionStrategy.getAttribute(request,
                StringUtils.upperCase(getRealValidateCodeProcessorType())
                        + ProjectConstant.VALIDATE_CODE_IN_SESSION_SUFFIX);
        String mobileInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "mobile");
        String validateCodeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "smsValidateCode");
        if (!StringUtils.equals(codeInSession.getMobile(),mobileInRequest) && StringUtils.equals(codeInSession.getCode(),validateCodeInRequest)){
            throw new LoginException("手机和验证码不匹配!");
        }

    }

    @Override
    public void doValidate(ServletWebRequest request) throws ServletRequestBindingException {
        super.doValidate(request);
    }

    @Override
    public void sendValidateCode(ServletWebRequest request, ValidateCode code) {
        smsValidateCodeSender.sendValidateCode(request, code);
    }

    @Override
    public String getRealValidateCodeProcessorType() {
        return "sms";
    }

    @Override
    public String getProcessingUrl() {
        return properties.getSmsValidateCodeProperties().getSmsValidateCodeProcessingUrl();
    }
}
