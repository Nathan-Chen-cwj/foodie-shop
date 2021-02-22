package net.seehope.foodie_shop.exception;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/8 11:01
 */
public class AddReceivingAddressException extends RuntimeException{

    private static final long serialVersionUID = 4383374525171288275L;

    public AddReceivingAddressException(String message) {
        super(message);
    }
}
