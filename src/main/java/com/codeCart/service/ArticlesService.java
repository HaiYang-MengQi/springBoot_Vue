package com.codeCart.service;

import com.codeCart.pojo.Articles;

import java.util.List;

public interface ArticlesService {
    List<Articles> getArticleById();
    void addArticle(Articles articles);
    void updateArticle(Articles articles);
    void deleteArticle(Integer id);

}
