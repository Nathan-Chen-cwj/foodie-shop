package net.seehope.foodie_shop.vo;

import lombok.Data;

import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/30 21:42
 */
@Data
public class SearchItemVo {
//    grid{
//        rows [ item{itemName,price,sellCounts}]
//        total 总页数
//        records 总记录数
//    }

    private List<RowsVo> rows;
    private Double total;
    private Integer records;
}
