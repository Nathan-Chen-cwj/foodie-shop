package net.seehope.foodie_shop.validate;


/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/24 21:32
 */
public class SmsValidateCode extends ValidateCode{
    private String mobile;

    public SmsValidateCode(String code, Integer effectiveIn, String mobile){
        super(code,effectiveIn);
        this.mobile=mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
