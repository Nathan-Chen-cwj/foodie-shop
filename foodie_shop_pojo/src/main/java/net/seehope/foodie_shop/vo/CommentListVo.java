package net.seehope.foodie_shop.vo;

import lombok.Data;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/1 9:29
 */
@Data
public class CommentListVo {
    private String userFace;
    private String createdTime;
    private String nickname;
    private String content;
    private String specName;
}
