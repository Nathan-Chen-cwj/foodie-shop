package net.seehope.foodie_shop.exception;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/20 23:34
 */
public class LogOutException extends RuntimeException{
    private static final long serialVersionUID = -5857289337488402435L;

    public LogOutException(String message) {
        super(message);
    }
}
