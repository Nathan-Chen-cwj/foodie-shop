package net.seehope.foodie_shop.validate;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/22 21:49
 */
@Component
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode>{
    @Override
    public void createValidateCode(ServletWebRequest request) throws IOException {
        super.createValidateCode(request);
    }

    @Override
    public void doValidate(ServletWebRequest request) {
        super.doValidate(request);
    }

    @Override
    public void sendValidateCode(ServletWebRequest request, ValidateCode code) {

    }

    @Override
    public String getRealValidateCodeProcessorType() {
        return "sms";
    }
}
