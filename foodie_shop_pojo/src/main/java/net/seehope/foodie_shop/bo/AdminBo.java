package net.seehope.foodie_shop.bo;

import lombok.Data;

import java.util.Date;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/15 22:42
 */
@Data
public class AdminBo {
    private String id;
    private String username;
    private String password;
    private String confirmPassword;
    private Date createTime;
    private Date updateTime;
}
