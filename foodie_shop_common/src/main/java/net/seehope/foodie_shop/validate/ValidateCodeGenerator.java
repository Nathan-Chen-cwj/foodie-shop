package net.seehope.foodie_shop.validate;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/21 16:56
 *
 * 验证码生成器的父接口
 */
public interface ValidateCodeGenerator {
    /**
     *验证码生成器
     * @return 验证码
     * @param request 请求信息
     * @throws ServletRequestBindingException
     */
    ValidateCode generatorValidateCode(ServletWebRequest request) throws ServletRequestBindingException;
}
