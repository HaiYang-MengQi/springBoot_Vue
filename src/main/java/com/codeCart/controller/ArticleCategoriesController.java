package com.codeCart.controller;

import com.codeCart.pojo.ArticleCategories;
import com.codeCart.pojo.Result;
import com.codeCart.service.ArticleCategoriesService;
import com.codeCart.util.ThreadLocalUtils;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articleCategories")
public class ArticleCategoriesController {
    @Autowired
    private ArticleCategoriesService articleCategoriesService;

    /**
     * 获取分类信息下的全部文章
     *
     */
    @GetMapping("/find")
    public Result<String[]> findCategories() {
        return Result.success(articleCategoriesService.selectAll());
    }
    @PostMapping("/add")
    public Result<Void> addCategories(@RequestBody ArticleCategories categories) {
        articleCategoriesService.addCategories(categories);
        return Result.success();
    }
    @PutMapping("/update")
    public Result<Void> updateCategories(@RequestBody ArticleCategories categories) {
        articleCategoriesService.updateCategories(categories);
        return Result.success();
    }
    @DeleteMapping("/delete")
    public Result<Void> deleteCategories(@RequestParam(required = false) String type, @RequestParam(required = false) String alias) {
        articleCategoriesService.deleteCategories(type,alias);
        return Result.success();
    }
}
