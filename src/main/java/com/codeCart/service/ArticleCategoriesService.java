package com.codeCart.service;

import com.codeCart.pojo.ArticleCategories;

import java.util.List;
import java.util.Map;

public interface ArticleCategoriesService {
    String[] selectAll(Integer id);
    void addCategories(ArticleCategories categories);
    void updateCategories(ArticleCategories categories);
    void deleteCategories(Map<String,Object> map);
}
