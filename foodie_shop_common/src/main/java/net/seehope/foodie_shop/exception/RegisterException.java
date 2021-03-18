package net.seehope.foodie_shop.exception;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/18 21:51
 */
public class RegisterException extends RuntimeException{
    private static final long serialVersionUID = 3483026524003200696L;

    public RegisterException(String message) {
        super(message);
    }
}
