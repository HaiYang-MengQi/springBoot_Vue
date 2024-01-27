package com.codecart.controller;


import com.codecart.pojo.Result;
import com.codecart.service.UserService;
import com.codecart.pojo.User;
import com.codecart.util.JWTUtils;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
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
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{4,10}$") String username,@Pattern(regexp = "^\\S{8,16}$") String password) throws Exception {
            User u = userService.findByUsername(username);
            if(u == null){
                return Result.error("用户名错误");
            }
            if(password.equals(u.getPassword())){
                Map<String, Object> map = new HashMap<>();
                map.put("id", u.getId());
                map.put("username", u.getUsername());
                String token = JWTUtils.generateToken(map);
                return Result.success(token);
            }
            return Result.error("密码错误");
    }
    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader("Authorization") String token){
    Map<String, Object> map = JWTUtils.parseToken(token);
    String username = (String) map.get("username");
    User u = userService.findByUsername(username);
    return Result.success(u);
    }
}
