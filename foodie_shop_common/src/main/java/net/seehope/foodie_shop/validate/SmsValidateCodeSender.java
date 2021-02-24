package net.seehope.foodie_shop.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/23 17:28
 *
 * 短信验证码发送接口
 */
public interface SmsValidateCodeSender {
    /**
     * 短信发送方法
     * @param request 请求和响应结合体
     * @param code 短信验证码相关信息
     */
    public void sendValidateCode(ServletWebRequest request, ValidateCode code);

}