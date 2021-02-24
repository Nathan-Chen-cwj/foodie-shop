package net.seehope.foodie_shop.validate;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/22 21:39
 *
 * 验证码处理器
 */
public interface ValidateCodeProcessor {
    /**
     * 创建 存储 发送验证码
     * @param request 请求、响应的结合体，用于获取请求和响应地址
     * @throws IOException
     */
    public void createValidateCode(ServletWebRequest request) throws IOException;

    /**
     * 验证验证码
     * @param request 请求、响应的结合体用于获取前端传来需要验证的验证码
     * @throws ServletRequestBindingException
     */
    public void doValidate(ServletWebRequest request) throws ServletRequestBindingException;

    /**
     *
     * @param request
     * @return
     */
    public boolean isNeedDoValidate(ServletWebRequest request);
}
