package net.seehope.foodie_shop.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/29 16:17
 */
@Data
public class SubCatListVo {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 分类名称
     */
    @Column(name = "`name`")
    private String name;
}
