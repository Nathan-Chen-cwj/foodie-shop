package net.seehope.foodie_shop.bo;

import lombok.Data;

import java.util.Date;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 17:56
 */
@Data
public class AddressBo {
    private String id;
    private String userId;
    private String receiver;
    private String mobile;
    private String province;
    private String city;
    private String district;
    private String detail;
    private Date createdTime;
    private Date updatedTime;
}
