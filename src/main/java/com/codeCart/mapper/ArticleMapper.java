package com.codeCart.mapper;

import com.codeCart.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {
    List<Article> findArticle(Article article);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(String title);
    List<Article> findArticleByCategories(Map<String,String> map);
}
