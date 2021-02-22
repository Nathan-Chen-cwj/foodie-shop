package net.seehope.foodie_shop.validate;

import java.awt.image.BufferedImage;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/20 15:54
 *
 * 生产图片验证码
 */
public class ImageValidateCode extends ValidateCode {
    private BufferedImage image;

    public ImageValidateCode(String code, Integer effectiveIn, BufferedImage image){
        super(code,effectiveIn);
        this.image=image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
