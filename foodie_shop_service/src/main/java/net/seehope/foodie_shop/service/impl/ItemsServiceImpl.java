package net.seehope.foodie_shop.service.impl;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import net.seehope.foodie_shop.mapper.*;
import net.seehope.foodie_shop.pojo.Items;
import net.seehope.foodie_shop.service.ItemsService;
import net.seehope.foodie_shop.vo.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/29 22:00
 */
@Slf4j
@Service
public class ItemsServiceImpl implements ItemsService {

    /**
     * itemInfo{
     *   items   item{ id,itemName,sellCounts }
     *   items_spec  itemSpecList[id name priceDiscount priceNormal discount]
     *   items_img itemImgList[url,sort,isMain]
     *   items_param itemParams{producPlace brand factoryName factoryAddress footPeriod weight storageMethod eatMethod} 产品详细信息
     *     }
     */
    @Autowired
    private ItemsSpecMapper itemsSpecMapper;

    @Autowired
    private ItemsImgMapper itemsImgMapper;

    @Autowired
    private ItemsParamMapper itemsParamMapper;

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private ItemsCommentsMapper itemsCommentsMapper;



    @Override
    public List<SimpleItemVo> querySimpleItemVo(Integer rootCatId) {
        return itemsMapper.querySimpleItemVo(rootCatId);
    }

    @Override
    public ItemInfoVo queryItemDetails(String itemId) {

//        itemInfoVo.setItem(itemsMapper.queryItemVo(itemId));
//        itemInfoVo.setItemSpecList(itemsSpecMapper.queryItemSpecListVo(itemId));
//        itemInfoVo.setItemParams(itemsParamMapper.queryItemParamsVo(itemId));
//        itemInfoVo.setItemImgList(itemsImgMapper.queryItemImgListVo(itemId));

        return itemsMapper.queryItemInfoVoByItemsId(itemId);
    }

    @Override
    public SearchItemVo searchItems(String keywords, String sort, Integer page, Integer pageSize) {
        SearchItemVo searchItemVo = new SearchItemVo();
        PageHelper.startPage(page, pageSize);
        List<RowsVo> rowsVos = itemsMapper.searchRowsVo("%" + keywords + "%", sort);
        Integer records = rowsVos.size();
        Double total =  Math.ceil(records/pageSize);
        searchItemVo.setRows(rowsVos);
        searchItemVo.setTotal(total);
        searchItemVo.setRecords(records);
        return searchItemVo;
    }

    @Override
    public ShowCommentsVo renderCommentLevelCounts(String itemId) {
        ShowCommentsVo showCommentsVo = new ShowCommentsVo();
        List<CommentLevelDto> dtos = itemsCommentsMapper.queryCommentLevelCounts(itemId);
        Integer goodComment = 0;
        Integer normalComment = 0;
        Integer badComment = 0;
        for (CommentLevelDto commentLevelDto : dtos){
             if(commentLevelDto.getCommentLevel()==1){
                 goodComment += commentLevelDto.getCountsNum();
             }else if(commentLevelDto.getCommentLevel()==2){
                 normalComment += commentLevelDto.getCountsNum();
             }else if(commentLevelDto.getCommentLevel()==3){
                 badComment += commentLevelDto.getCountsNum();
             }else {
                 throw new RuntimeException("与数据库字段不匹配！");
             }
        }
        Integer total = goodComment+normalComment+badComment;
        showCommentsVo.setTotalCounts(total);
        showCommentsVo.setGoodCounts(goodComment);
        showCommentsVo.setNormalCounts(normalComment);
        showCommentsVo.setBadCounts(badComment);
        return showCommentsVo;
    }

    @Override
    public RenderCommentsVo renderComments(String itemId,String level,String page,String pageSize) {
        RenderCommentsVo renderCommentsVo = new RenderCommentsVo();
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(pageSize));
        List<CommentListVo> commentListVos = itemsCommentsMapper.queryComments(itemId,level);
        Integer records = commentListVos.size();
        Double total = Math.ceil(records/Integer.parseInt(pageSize));
        renderCommentsVo.setRows(commentListVos);
        renderCommentsVo.setRecords(records);
        renderCommentsVo.setTotal(total);
        return renderCommentsVo;
    }

    /**
     * string util bean util collection util
     * @param specIds
     * @return
     */
    @Override
    public List<ShopCarItemVo> queryShopCarItems(String[] specIds) {
        List<String> ids = new ArrayList<String>(specIds.length);
        CollectionUtils.addAll(ids,specIds);
        return itemsMapper.queryShopCarOperation(ids);
    }


}
