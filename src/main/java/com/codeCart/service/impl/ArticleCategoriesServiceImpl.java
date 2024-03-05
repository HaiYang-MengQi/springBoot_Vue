package com.codeCart.service.impl;

import com.codeCart.mapper.ArticleCategoriesMapper;
import com.codeCart.pojo.ArticleCategories;
import com.codeCart.service.ArticleCategoriesService;
import com.codeCart.util.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleCategoriesServiceImpl implements ArticleCategoriesService {
    @Autowired
    private ArticleCategoriesMapper  articleCategoriesMapper;
    /**
     * @return 返回登录用户创建文章类型信息
     */
    @Override
    public String[] selectAll( ) {
        Map<String, Object> map = ThreadLocalUtils.get();
        Integer id = (Integer) map.get("id");
        return articleCategoriesMapper.selectAll(id);
    }

    /**
     * @param categories 要添加的文章类型信息
     */
    @Override
    public void addCategories(ArticleCategories categories) {
        Map<String, Object> map = ThreadLocalUtils.get();
        Integer id = (Integer) map.get("id");
        categories.setCreatedBy(id);
        articleCategoriesMapper.addCategories(categories);
    }

    /**
     * @param categories 要更新的文章类型载荷
     */
    @Override
    public void updateCategories(ArticleCategories categories) {
        Map<String, Object> map = ThreadLocalUtils.get();
        Integer id = (Integer) map.get("id");
        categories.setCreatedBy(id);
        articleCategoriesMapper.updateCategories(categories);
    }

    /**
     * @param type  要删除的文章类型名
     * @param alias 要删除的文章类型别名
     */
    @Override
    public void deleteCategories(String type, String alias) {
        Map<String, Object> map1 = ThreadLocalUtils.get();
        Integer id = (Integer) map1.get("id");
        Map<String, Object> map = new HashMap<>();
        map.put("created_by", id);
        map.put("type", type);
        map.put("alias", alias);
        articleCategoriesMapper.deleteCategories(map);
    }
}
