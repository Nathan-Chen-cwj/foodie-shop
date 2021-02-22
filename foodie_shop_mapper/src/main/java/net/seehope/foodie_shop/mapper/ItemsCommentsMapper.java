package net.seehope.foodie_shop.mapper;

import net.seehope.foodie_shop.pojo.ItemsComments;
import net.seehope.foodie_shop.vo.CommentLevelDto;
import net.seehope.foodie_shop.vo.CommentListVo;
import net.seehope.foodie_shop.vo.ShowCommentsVo;

import java.util.List;

/**
* 通用 Mapper 代码生成器
*
* @author mapper-generator
*/
public interface ItemsCommentsMapper extends tk.mybatis.mapper.common.Mapper<ItemsComments> {
    ShowCommentsVo queryGoodComments(String itemId);
    ShowCommentsVo queryNormalComments(String itemId);
    ShowCommentsVo queryBadComments(String itemId);
    ShowCommentsVo queryCountComments(String itemId);

    List<CommentLevelDto> queryCommentLevelCounts(String itemId);


    List<CommentListVo> queryComments(String itemId,String level);

}




