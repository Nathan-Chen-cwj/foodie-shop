package net.seehope.foodie_shop.service.impl;

import net.seehope.foodie_shop.mapper.CarouselMapper;
import net.seehope.foodie_shop.mapper.CategoryMapper;
import net.seehope.foodie_shop.mapper.ItemsMapper;
import net.seehope.foodie_shop.pojo.Carousel;
import net.seehope.foodie_shop.pojo.Category;
import net.seehope.foodie_shop.service.IndexService;
import net.seehope.foodie_shop.vo.*;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/29 10:47
 *
 * 首页相关服务查询服务实现类
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ItemsMapper itemsMapper;

    /**
     * 查询轮播图实现方法
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public List<RenderCarouselVo> getRenderCarouselVo() throws InvocationTargetException, IllegalAccessException {
        // 创建前端轮播图装载容器 该容器由前端决定 通过查看前端可知需要封装的模型以及名称
        List<RenderCarouselVo> carouselVos = new ArrayList<>();
        // 调用查找轮播图的mapper
        List<Carousel> carouselList = carouselMapper.selectAll();
        for (Carousel carousel : carouselList) {
            RenderCarouselVo vo = new RenderCarouselVo();
            /*
             BeanUtils.copyProperties方法进行对象之间属性的赋值，避免通过get、set方法一个一个属性的赋值
             (targetDTO,pojo)
             */
            BeanUtils.copyProperties(vo, carousel);
            // 装载进返回对象
            carouselVos.add(vo);
        }
        return carouselVos;
    }

    @Override
    public List<CategoryRootVo> getCategoryRootItemsList() throws InvocationTargetException, IllegalAccessException {
        Category cate = new Category();
        cate.setType(1);
        List<CategoryRootVo> categoryRootVo = new ArrayList<>();
        List<Category> categoryRootList = categoryMapper.select(cate);
        for (Category category : categoryRootList) {
            CategoryRootVo vo = new CategoryRootVo();
            BeanUtils.copyProperties(vo, category);
            categoryRootVo.add(vo);
        }
        return categoryRootVo;
    }

    /**
     * select * from category c1
     * left join category c2 on c1.id = c2.father_id
     * left join category c3 on c2.id = c3.father_id
     * where c1.id = 1;
     * @param rootCatId
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public List<CategoryChildVo> getCategoryChildItemsList(Integer rootCatId) throws InvocationTargetException, IllegalAccessException {
        Category cate = new Category();
        cate.setFatherId(rootCatId);
        List<Category> categoryRootList = categoryMapper.select(cate);
        List<CategoryChildVo> result = new ArrayList<CategoryChildVo>();
        for (Category category : categoryRootList) {
            CategoryChildVo vo = new CategoryChildVo();
            Integer fatherId = category.getId();
            vo.setName(category.getName());
            cate.setFatherId(fatherId);
            List<Category> categories =  categoryMapper.select(cate);
            List<SubCatListVo> subCatListVos = new ArrayList<>();
            for (Category category1 : categories){
                SubCatListVo subCatListVo = new SubCatListVo();
                subCatListVo.setId(category1.getId());
                subCatListVo.setName(category1.getName());
                subCatListVos.add(subCatListVo);
            }
            vo.setSubCatList(subCatListVos);
            result.add(vo);
        }
        return result;
    }

    /**
     * select * from category where id = rootCatId;
     * select * from items i
     * left join items_img ii on  i.id = ii.item_id
     * where root_cat_id = #{rootCatId}
     * and ii.is_main = 1
     * limit 6
     * @param rootCatId
     * @return
     */
    @Override
    public SixNewItemsVo renderSixNewItems(Integer rootCatId) {
        Category category = categoryMapper.selectByPrimaryKey(rootCatId);
        SixNewItemsVo result = new SixNewItemsVo();
        result.setRootCatName(category.getName());
        result.setBgColor(category.getBgColor());
        result.setCatImage(category.getCatImage());
        result.setSlogan(category.getSlogan());
        result.setSimpleItemList(itemsMapper.querySimpleItemVo(rootCatId));
        return result;
    }

}

