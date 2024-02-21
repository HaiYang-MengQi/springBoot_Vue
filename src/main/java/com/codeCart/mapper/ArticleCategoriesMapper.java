package com.codeCart.mapper;
import com.codeCart.pojo.ArticleCategories;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleCategoriesMapper {
    /**
     * 查询所有的文章分类
     */
    String[] selectAll(Integer id);
    /**
     * 添加文章分类
     */
    void addCategories(ArticleCategories categories);
    /**
     * 更新文章分类
     */
    void updateCategories(ArticleCategories categories);
    /**
     * 删除文章分类
     */
    void deleteCategories(Map<String,Object> map);
}
