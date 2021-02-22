package net.seehope.foodie_shop.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/4 11:43
 */
public class LoginException extends UsernameNotFoundException {
    private static final long serialVersionUID = 4215896548124831538L;

    public LoginException(String msg) {
        super(msg);
    }
}
