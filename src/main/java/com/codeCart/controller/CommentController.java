package com.codeCart.controller;

import com.codeCart.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @GetMapping("/list")
    public Result list() {
        return Result.success("加载所有评论");
    }

}
