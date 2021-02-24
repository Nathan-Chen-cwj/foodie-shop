package net.seehope.foodie_shop.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/24 22:56
 */
public class GetUserException extends UsernameNotFoundException {
    private static final long serialVersionUID = 1453886373367775525L;

    public GetUserException(String msg) {
        super(msg);
    }
}
