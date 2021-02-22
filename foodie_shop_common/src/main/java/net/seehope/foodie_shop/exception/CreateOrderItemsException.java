package net.seehope.foodie_shop.exception;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/3 17:14
 */
public class CreateOrderItemsException extends RuntimeException {

    private static final long serialVersionUID = -1855448834078856022L;


    public CreateOrderItemsException(String message) {
        super(message);
    }
}
