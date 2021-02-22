package net.seehope.foodie_shop.common;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/22 22:33
 */
public class SmsValidateCodeProperties {
    /**
     * 默认有效输入时间
     */
    private Integer effectiveIn = 60*10;
    /**
     * 默认验证码长度
     */
    private Integer smsValidateCodeLength = 6;

    public SmsValidateCodeProperties() {
    }

    public SmsValidateCodeProperties(Integer effectiveIn, Integer smsValidateCodeLength) {
        this.effectiveIn = effectiveIn;
        this.smsValidateCodeLength = smsValidateCodeLength;
    }

    public Integer getEffectiveIn() {
        return effectiveIn;
    }

    public void setEffectiveIn(Integer effectiveIn) {
        this.effectiveIn = effectiveIn;
    }

    public Integer getSmsValidateCodeLength() {
        return smsValidateCodeLength;
    }

    public void setSmsValidateCodeLength(Integer smsValidateCodeLength) {
        this.smsValidateCodeLength = smsValidateCodeLength;
    }
}
