package com.codeCart.controller;

import com.codeCart.pojo.Article;
import com.codeCart.pojo.Result;
import com.codeCart.service.ArticleService;
import com.codeCart.util.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/find")
    public Result<List<Article>> findArticle(@RequestBody Article article)
    {// todo 缺一个请求体什么都不带就是查询全部
        return Result.success(articleService.findArticle(article));
    }
    @PostMapping("/add")
    public Result<Void> addArticle(@RequestBody @Validated Article article)
    {
        articleService.addArticle(article);
        return Result.success();
    }
    @PutMapping("/update")
    public Result<Void> updateArticle(@RequestBody Article article)
    {
        articleService.updateArticle(article);
        return Result.success();
    }
    @DeleteMapping("/delete")
    public Result<String> deleteArticleByTitle(@RequestParam String title)
    {
        articleService.deleteArticle(title);
        return Result.success("删除成功!");
    }
    @GetMapping("/categoriesArticles")
    public Result<List<Article>> getArticlesByCategoryAndAlias(@RequestParam String type, @RequestParam(required = false) String alias)
    {
        Map<String,String> map = Map.of("type",type,"alias",alias);
        List<Article> articles = articleService.findArticleByCategorie(map);
        return Result.success(articles);
    }
}
