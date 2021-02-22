package net.seehope.foodie_shop.exception;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/3 10:20
 */
public class SetReceivingAddressNotToDefaultException extends RuntimeException {

    private static final long serialVersionUID = -3585609091238217894L;

    public SetReceivingAddressNotToDefaultException() {

    }

    public SetReceivingAddressNotToDefaultException(String msg) {
        super(msg);
    }

}
