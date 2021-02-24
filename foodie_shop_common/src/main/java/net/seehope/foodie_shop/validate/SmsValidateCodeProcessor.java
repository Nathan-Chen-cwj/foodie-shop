package net.seehope.foodie_shop.validate;

import net.seehope.foodie_shop.common.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
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

    @Override
    public void createValidateCode(ServletWebRequest request) throws IOException {
        super.createValidateCode(request);
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
