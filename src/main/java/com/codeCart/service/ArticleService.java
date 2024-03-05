package com.codeCart.service;

import com.codeCart.pojo.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    List<Article> findArticle(Article article);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(String title);
    List<Article> findArticleByCategorie(Map<String,String> map);
}
