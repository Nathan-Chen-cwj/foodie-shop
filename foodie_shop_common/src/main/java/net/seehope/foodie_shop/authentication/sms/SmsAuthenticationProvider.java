package net.seehope.foodie_shop.authentication.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/24 15:52
 */
public class SmsAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    @Override
    public boolean supports(Class<?> authentication) {
        return (SmsAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsAuthenticationToken token = (SmsAuthenticationToken) authentication;
        //传手机号到数据库查看是否有对应的用户 有问题！！！这里是要传递真正的username
        UserDetails user = userDetailsService.loadUserByUsername(token.getPrincipal() + "");
        if (user==null){
            throw new InternalAuthenticationServiceException("无法获得用户");
        }
        SmsAuthenticationToken smsAuthenticationToken = new SmsAuthenticationToken(token.getPrincipal(), token.getCredentials(), token.getAuthorities());
        smsAuthenticationToken.setDetails(token.getDetails());
        return smsAuthenticationToken;
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
