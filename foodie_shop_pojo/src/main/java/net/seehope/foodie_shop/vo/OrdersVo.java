package net.seehope.foodie_shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/3 14:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersVo {
    private List<OrderListVo> rows;
    private double total;
    private int records;
    private int totalRecords;
}
