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
public class ArticleController {
    @Autowired
    private ArticleCategoriesService articleCategoriesService;

    /**
     * 获取分类信息下的全部文章
     *
     */
    @GetMapping("/findAll")
    public Result<String[]> findCategories() {
        Map<String, Object> map = ThreadLocalUtils.get();
        final Integer id = (Integer) map.get("id");
        return Result.success(articleCategoriesService.selectAll(id));
    }
    @PostMapping("/add")
    public Result<Void> addCategories(@RequestBody ArticleCategories categories) {
        Map<String, Object> map = ThreadLocalUtils.get();
         final Integer id = (Integer) map.get("id");
        categories.setCreatedBy(id);
        articleCategoriesService.addCategories(categories);
        return Result.success();
    }
    @PutMapping("/update")
    public Result<Void> updateCategories(@RequestBody ArticleCategories categories) {
        Map<String, Object> map = ThreadLocalUtils.get();
        final Integer id = (Integer) map.get("id");
        categories.setCreatedBy(id);
        articleCategoriesService.updateCategories(categories);
        return Result.success();
    }
    @DeleteMapping("/delete")
    public Result<Void> deleteCategories(@RequestParam(required = false) String type, @RequestParam(required = false) String alias) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = ThreadLocalUtils.get();
        final Integer id = (Integer) map1.get("id");
        map.put("created_by", id);
        map.put("type", type);
        map.put("alias", alias);
        articleCategoriesService.deleteCategories(map);
        return Result.success();
    }
}
