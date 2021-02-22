package net.seehope.foodie_shop.common;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/23 0:26
 */
public class EmailValidateCodeProperties {

    private Integer effectiveIn = 60*10;
    private Integer emailValidateCodeLength = 6;

    public EmailValidateCodeProperties() {
    }

    public EmailValidateCodeProperties(Integer effectiveIn, Integer emailValidateCodeLength) {
        this.effectiveIn = effectiveIn;
        this.emailValidateCodeLength = emailValidateCodeLength;
    }

    public Integer getEffectiveIn() {
        return effectiveIn;
    }

    public void setEffectiveIn(Integer effectiveIn) {
        this.effectiveIn = effectiveIn;
    }

    public Integer getEmailValidateCodeLength() {
        return emailValidateCodeLength;
    }

    public void setEmailValidateCodeLength(Integer emailValidateCodeLength) {
        this.emailValidateCodeLength = emailValidateCodeLength;
    }
}
