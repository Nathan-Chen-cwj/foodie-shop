package net.seehope.foodie_shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/28 20:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersVo {
    private String id;
    private String username;
    private String mobile;
    private String email;
}
