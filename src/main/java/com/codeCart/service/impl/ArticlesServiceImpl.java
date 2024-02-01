package com.codeCart.service.impl;

import com.codeCart.mapper.ArticlesMapper;
import com.codeCart.pojo.Articles;
import com.codeCart.service.ArticlesService;
import com.codeCart.util.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticlesServiceImpl implements ArticlesService {
    @Autowired
    private ArticlesMapper articlesMapper;

    @Override
    public List<Articles> getArticleById() {
        Map<String, Object> map = ThreadLocalUtils.get();
        return articlesMapper.getArticleById((Integer) map.get("id"));
    }

    @Override
    public void addArticle(Articles articles) {
        Map<String, Object> map = ThreadLocalUtils.get();
        Integer userId = (Integer) map.get("id");
        articles.setAuthorId(userId);
        articlesMapper.addArticle(articles);
    }

    @Override
    public void updateArticle(Articles articles) {
        articlesMapper.updateArticle(articles);
    }

    @Override
    public void deleteArticle(Integer id) {
        articlesMapper.deleteArticle(id);
    }
}
