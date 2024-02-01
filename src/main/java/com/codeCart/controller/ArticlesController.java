package com.codeCart.controller;

import com.codeCart.pojo.Articles;
import com.codeCart.pojo.Result;
import com.codeCart.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
    @Autowired
    ArticlesService articlesService;
    @GetMapping("/getArticle")
    public Result getArticleById()
    {
        List<Articles> articles = articlesService.getArticleById();
        System.out.println(articles);
        return Result.success(articles);
    }
    @PostMapping("/addArticle")
    public Result  addArticle(@RequestBody @Validated(Articles.Add.class) Articles articles)
    {
        articlesService.addArticle(articles);
        return Result.success();
    }
    @PutMapping("/updateArticle")
    public Result updateArticle(@RequestBody @Validated Articles articles)
    {
        articlesService.updateArticle(articles);
        return Result.success();
    }
    @DeleteMapping("/deleteArticle")
    public Result deleteArticle(Integer id)
    {
        articlesService.deleteArticle(id);
        return Result.success();
    }
}
