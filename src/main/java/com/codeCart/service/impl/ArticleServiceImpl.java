package com.codeCart.service.impl;

import com.codeCart.mapper.ArticleMapper;
import com.codeCart.pojo.Article;
import com.codeCart.service.ArticleService;
import com.codeCart.util.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    /**
     * @param article 根据参数查询
     * @return
     */
    @Override
    public List<Article> findArticle(Article article) {
        Map<String,Object> map = ThreadLocalUtils.get();
        Integer  id = (Integer) map.get("id");
            article.setUserId(id);
            return articleMapper.findArticle(article);
        }


    /**
     * @param article
     */
    @Override
    public void addArticle(Article article) {
        Map<String,Object> map = ThreadLocalUtils.get();
        Integer  id = (Integer) map.get("id");
        article.setUserId(id);
        articleMapper.addArticle(article);
    }

    /**
     * @param article
     */
    @Override
    public void updateArticle(Article article) {
        Map<String,Object> map = ThreadLocalUtils.get();
        Integer  id = (Integer) map.get("id");
        article.setId(id);
        articleMapper.updateArticle(article);
    }

    /**
     * @param title
     */
    @Override
    public void deleteArticle(String title) {
        articleMapper.deleteArticle(title);
    }
    public List<Article> findArticleByCategorie(Map<String,String> map)
    {
        return articleMapper.findArticleByCategories(map);
    }
}
