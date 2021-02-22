package net.seehope.foodie_shop.validate;

import java.time.LocalDateTime;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/20 15:41
 *
 * 所有验证码的父类
 * 图片验证、短信验证、邮箱验证等
 */
public class ValidateCode {
    /**
     * 验证码实体
     */
    private String code;
    /**
     * 有效时间
     */
    private LocalDateTime effectiveTime;

    public ValidateCode() {
    }

    public ValidateCode(String code, LocalDateTime effectiveTime) {
        this.code = code;
        this.effectiveTime = effectiveTime;
    }

    public ValidateCode(String code, Integer effectiveIn) {
        this.code = code;
        this.effectiveTime = LocalDateTime.now().plusSeconds(effectiveIn);
    }

    /**
     * 判断是否失效
     */
    public boolean isExpire(){
        return LocalDateTime.now().isAfter(effectiveTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(LocalDateTime effectiveTime) {
        this.effectiveTime = effectiveTime;
    }
}
