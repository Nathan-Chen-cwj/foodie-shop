package net.seehope.foodie_shop.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author volar
 * @version 1.0
 * @Package com.volar.foodie.vo
 * @date 2021/2/2 12:18
 */
@Data
public class UserAddressVo implements Serializable {
    private String id;
    private String userId;
    private String isDefault;
    private String receiver;
    private String mobile;
    private String province;
    private String city;
    private String district;
    private String detail;
}
