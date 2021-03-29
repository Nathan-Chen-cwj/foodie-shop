package net.seehope.foodie_shop.vo;

import lombok.Data;

import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/1 9:27
 */
@Data
public class RenderCommentsVo {

    private Double total;
    private Integer records;
    private List<CommentListVo> rows;
}
