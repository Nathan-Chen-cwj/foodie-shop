package net.seehope.foodie_shop.common;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/21 15:48
 */
public class ImageValidateCodeProperties {
    /**
     * 图片验证码验证处理地址
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
    private int codeLength=4;
    /**
     * 图片验证码有效长度
     */
    private int effectiveIn=60*15;

    public ImageValidateCodeProperties() {
    }

    public ImageValidateCodeProperties(String imageValidateCodeProcessingUrl, int width, int height, int codeLength, int effectiveIn) {
        this.imageValidateCodeProcessingUrl = imageValidateCodeProcessingUrl;
        this.width = width;
        this.height = height;
        this.codeLength = codeLength;
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

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public int getEffectiveIn() {
        return effectiveIn;
    }

    public void setEffectiveIn(int effectiveIn) {
        this.effectiveIn = effectiveIn;
    }
}
