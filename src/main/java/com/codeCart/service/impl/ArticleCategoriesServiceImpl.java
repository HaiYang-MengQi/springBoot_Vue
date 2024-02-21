package com.codeCart.service.impl;

import com.codeCart.mapper.ArticleCategoriesMapper;
import com.codeCart.pojo.ArticleCategories;
import com.codeCart.service.ArticleCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleCategoriesServiceImpl implements ArticleCategoriesService {
    @Autowired
    private ArticleCategoriesMapper  articleCategoriesMapper;
    /**
     * @return
     */
    @Override
    public String[] selectAll(Integer id) {
        return articleCategoriesMapper.selectAll(id);
    }

    /**
     * @param categories
     */
    @Override
    public void addCategories(ArticleCategories categories) {
        articleCategoriesMapper.addCategories(categories);
    }

    /**
     * @param categories
     */
    @Override
    public void updateCategories(ArticleCategories categories) {
        articleCategoriesMapper.updateCategories(categories);
    }

    /**
     * @param id
     */
    @Override
    public void deleteCategories(Map<String,Object> map) {
        articleCategoriesMapper.deleteCategories(map);
    }
}
