package net.seehope.foodie_shop.common;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/21 15:48
 */
public class ImageValidateCodeProperties {
    /**
     * 图片验证码验证时需要验证的路径，
     * 如果有多个路径，以逗号隔开
     * （因为不光登陆可以采用图片验证码这种验证方式、注册、支付等也可能需要
     * 所以验证过滤器尽量要做到可重用，所以把需要验证的路径做成一个集合）
     */
    private String imageValidateCodeProcessingUrl="/authentication/form";
    /**
     * 图片验证码宽度
     */
    private int width=67;
    /**
     * 图片验证码高度
     */
    private int height=23;
    /**
     * 图片验证码长度
     */
    private int imageValidateCodeLength=4;
    /**
     * 图片验证码有效长度
     */
    private int effectiveIn=60*15;

    public ImageValidateCodeProperties() {
    }

    public ImageValidateCodeProperties(String imageValidateCodeProcessingUrl, int width, int height, int imageValidateCodeLength, int effectiveIn) {
        this.imageValidateCodeProcessingUrl = imageValidateCodeProcessingUrl;
        this.width = width;
        this.height = height;
        this.imageValidateCodeLength = imageValidateCodeLength;
        this.effectiveIn = effectiveIn;
    }

    public String getImageValidateCodeProcessingUrl() {
        return imageValidateCodeProcessingUrl;
    }

    public void setImageValidateCodeProcessingUrl(String imageValidateCodeProcessingUrl) {
        this.imageValidateCodeProcessingUrl = imageValidateCodeProcessingUrl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getImageValidateCodeLength() {
        return imageValidateCodeLength;
    }

    public void setImageValidateCodeLength(int imageValidateCodeLength) {
        this.imageValidateCodeLength = imageValidateCodeLength;
    }

    public int getEffectiveIn() {
        return effectiveIn;
    }

    public void setEffectiveIn(int effectiveIn) {
        this.effectiveIn = effectiveIn;
    }
}
