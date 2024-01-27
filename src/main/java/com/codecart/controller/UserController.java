package com.codecart.controller;


import com.codecart.pojo.Result;
import com.codecart.service.UserService;
import com.codecart.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(String username,String password) throws Exception {
        //查询用户
        User u = userService.findByUsername(username);
        if (u == null) {
            //没有占用注册
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户已存在");
        }
    }
}
