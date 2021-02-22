package net.seehope.foodie_shop.vo;


import lombok.Data;

/**
 * 渲染首页轮播图需要的数据字段
 * 通过查看前端vue变量装载方式与命名确定返回的对象的名称和个数
 * @author NathanChen
 *
 */
@Data
public class RenderCarouselVo {

//	carouselList[type catId itemId backgroundColor imageUrl]

	private String type;
	private String catId;
	private String itemId;
	private String backgroundColor;
	private String imageUrl;

}
