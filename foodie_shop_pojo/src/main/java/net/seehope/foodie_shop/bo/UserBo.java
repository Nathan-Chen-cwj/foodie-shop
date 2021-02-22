package net.seehope.foodie_shop.bo;

import lombok.Data;

import java.util.Date;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 11:03
 */
@Data
public class UserBo {
    private String id;
    private String username;
    private String password;
    private String confirmPassword;
    private Date createTime;
    private Date updateTime;
    private String face;
}
