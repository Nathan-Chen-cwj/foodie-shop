package net.seehope.foodie_shop.vo;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/29 15:39
 */
@Data
public class CategoryChildVo {

    private String name;

    private List<SubCatListVo> subCatList;
}
