package net.seehope.foodie_shop.vo;

import lombok.Data;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/30 22:52
 *
 * 展示评论的vo
 */
@Data
public class ShowCommentsVo {
//    countsVO{
//        goodCounts,好评数
//        totalCounts,评价总计数
//        normalCounts,中评数
//        badCounts,差评数
//    }
    private Integer goodCounts;
    private Integer normalCounts;
    private Integer badCounts;
    private Integer totalCounts;
}
