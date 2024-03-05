package com.codeCart.service;

import com.codeCart.pojo.ArticleCategories;

import java.util.List;
import java.util.Map;

public interface ArticleCategoriesService {
    String[] selectAll();
    void addCategories(ArticleCategories categories);
    void updateCategories(ArticleCategories categories);
    void deleteCategories(String type, String alias);
}
