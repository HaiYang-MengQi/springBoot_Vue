package com.codecart.controller;

import com.codecart.pojo.Result;
import com.codecart.util.JWTUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @GetMapping("/list")
    public Result list() {
//        try{
//            Map<String, Object> claims =  JWTUtils.parseToken(token);
//            return Result.success("加载所有评论");
//        }catch (Exception e){
//            response.setStatus(401);
//            return Result.error("未登录");
//        }
        return Result.success("加载所有评论");
    }

}
