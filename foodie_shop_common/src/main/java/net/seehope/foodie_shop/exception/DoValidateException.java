package net.seehope.foodie_shop.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/20 17:42
 */
public class DoValidateException extends AuthenticationException {

    private static final long serialVersionUID = -2206358719742307421L;

    public DoValidateException(String explanation) {
        super(explanation);
    }
}
