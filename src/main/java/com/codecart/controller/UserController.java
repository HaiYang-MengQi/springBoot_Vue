package com.codecart.controller;


import com.codecart.pojo.Result;
import com.codecart.service.UserService;
import com.codecart.pojo.User;
import com.codecart.util.JWTUtils;
import com.codecart.util.ThreadLocalUtils;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated //使用校验功能,@Pattern
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{4,10}$") String username,@Pattern(regexp = "^\\S{8,16}$") String password) throws Exception {
        User u = userService.findByUsername(username);
        if (u == null) {
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户已存在");
        }
    }
    /**
     * @Author: haiyang
     * @param username 提供登录的用户名
     * @param password 提供登录的密码
     * @Patten 代表匹配正则表达式
     * @return
     *
     */
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{4,10}$") String username,@Pattern(regexp = "^\\S{8,16}$") String password) throws Exception {
        //通过查询用户是否存在
            User u = userService.findByUsername(username);
            if(u == null){
                return Result.error("用户名错误");
            }
            //存在即校验代码
        //todo 此处应该使用加密算法
            if(password.equals(u.getPassword())){
                Map<String, Object> map = new HashMap<>();
                map.put("id", u.getId());
                map.put("username", u.getUsername());
                String token = JWTUtils.generateToken(map);
                return Result.success(token);
            }
            return Result.error("密码错误");
    }

    /**
     * @Author: haiyang
     * @param token @RequestHeader("Authorization") String token已启用
     * @return
     */
    @GetMapping("/userInfo")
    public Result<User> userInfo(){
    Map<String, Object> map = ThreadLocalUtils.get();
    String username = (String) map.get("username");
    User u = userService.findByUsername(username);
    return Result.success(u);
    }

    /**
     *
     * @param user 前端传入的数据
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        System.out.println(user);
        userService.update(user);
        return Result.success();
    }
}
