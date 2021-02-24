package net.seehope.foodie_shop.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/23 17:29
 */
public class DefaultSmsValidateCodeSender implements SmsValidateCodeSender{
    private static final Logger logger = LoggerFactory.getLogger(DefaultSmsValidateCodeSender.class);
    @Override
    public void sendValidateCode(ServletWebRequest request, ValidateCode code) {
        logger.info("并没有真正实现短信发送业务，如需发送短信请实现SmsValidateCodeSender接口，覆盖默认逻辑以发送短信"
                +request.getRequest().getParameter("mobile")+"|||"+code.getCode());
    }
}
