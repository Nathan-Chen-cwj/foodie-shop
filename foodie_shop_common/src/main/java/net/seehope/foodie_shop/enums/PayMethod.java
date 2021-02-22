package net.seehope.foodie_shop.enums;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 19:57
 */
public enum PayMethod{
    /**
     * 以下写法相当于
     * public static final PayMethod WE_CHAT = new PayMethod(1,"微信支付");
     * public static final PayMethod ALI_PAY = new PayMethod(2,"支付宝支付");
     *
     * content 描述
     */

    WE_CHAT(1,"微信支付"),ALI_PAY(2,"支付宝支付");

    public final int type;
    public final String content;

    private PayMethod(int type, String content) {
        this.type = type;
        this.content = content;
    }
}
