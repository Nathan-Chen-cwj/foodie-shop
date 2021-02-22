package net.seehope.foodie_shop.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/29 14:47
 */
@Data
public class CategoryRootVo {
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

    /**
     * 分类类型
     */
    @Column(name = "`type`")
    private Integer type;

    /**
     * 父id
     */
    @Column(name = "`father_id`")
    private Integer fatherId;

    /**
     * 图标
     */
    @Column(name = "`logo`")
    private String logo;

    /**
     * 口号
     */
    @Column(name = "`slogan`")
    private String slogan;

    /**
     * 分类图
     */
    @Column(name = "`cat_image`")
    private String catImage;
}
