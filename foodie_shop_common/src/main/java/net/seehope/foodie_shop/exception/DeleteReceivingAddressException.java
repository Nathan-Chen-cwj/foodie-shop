package net.seehope.foodie_shop.exception;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/8 17:43
 */
public class DeleteReceivingAddressException extends RuntimeException {
    private static final long serialVersionUID = -4930898058939695336L;

    public DeleteReceivingAddressException(String message) {
        super(message);
    }
}
