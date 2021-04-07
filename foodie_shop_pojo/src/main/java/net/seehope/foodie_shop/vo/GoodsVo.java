package net.seehope.foodie_shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/3/28 20:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo {
    private List<GoodListVo> rows;
    private double total;
    private int records;
    /**
     * 总数
     */
    private int totalRecords;

}
