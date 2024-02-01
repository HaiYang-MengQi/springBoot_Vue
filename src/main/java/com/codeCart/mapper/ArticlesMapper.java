package com.codeCart.mapper;

import com.codeCart.pojo.Articles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticlesMapper {
    List<Articles> getArticleById(Integer id);
    void addArticle(Articles articles);
    void updateArticle(Articles articles);
    void deleteArticle(Integer id);
}
