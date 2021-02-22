package net.seehope.foodie_shop.exception;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/8 17:38
 */
public class UpdateReceivingAddressException extends RuntimeException{
    private static final long serialVersionUID = -821490651457446448L;

    public UpdateReceivingAddressException(String message) {
        super(message);
    }
}
