package net.seehope.foodie_shop.bo;

import lombok.Data;

import java.util.Date;

/**
 * @Author NathanChen
 * @Date 2021/3/30 10:16
 * @Version 1.0
 */
@Data
public class ImgUrlBo {
    private String itemsImgId;
    private String itemId;
    private String url;
    private int isMain;
    private int sort;
    private Date createdTime;
    private Date updatedTime;
}
