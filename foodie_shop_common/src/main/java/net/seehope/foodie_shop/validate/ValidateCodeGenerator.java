package net.seehope.foodie_shop.validate;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/21 16:56
 *
 * 验证码生成器的父接口
 */
public interface ValidateCodeGenerator {
    /**
     * 验证码生成器
     * @return 验证码
     */
    ValidateCode generatorValidateCode();
}
