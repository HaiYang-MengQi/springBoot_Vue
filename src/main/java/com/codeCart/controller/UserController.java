package com.codeCart.controller;


import com.codeCart.pojo.Result;
import com.codeCart.pojo.User;
import com.codeCart.pojo.UserInfo;
import com.codeCart.service.UserService;
import com.codeCart.util.JWTUtils;
import com.codeCart.util.ThreadLocalUtils;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated //使用校验功能,@Pattern
public class UserController {
    @Autowired
    private UserService userService;
    private static List<Integer> list = new ArrayList<>();
    @PostMapping("/register")
    public Result<String> register(@Pattern(regexp = "^\\S{4,10}$") String username,@Pattern(regexp = "^\\S{8,16}$") String password)  {
        User u = userService.findByUsername(username);
        if (u == null) {
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户已存在");
        }
    }
    /**
     * @Author: haiYang
     * @param username 提供登录的用户名
     * @param password 提供登录的密码
     * @Patten 代表匹配正则表达式
     * @return 返回JWT令牌
     *
     */
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{4,10}$") String username,@Pattern(regexp = "^\\S{8,16}$") String password)  {
        //通过查询用户是否存在
            User u = userService.findByUsername(username);
            if(u == null){
                return Result.error("用户名错误");
            }
            //存在即校验代码
        //todo 此处应该使用加密算法
            if(password.equals(u.getPassword())){
                userService.updateLoginTime(u.getId());
                Map<String, Object> map = new HashMap<>();
                map.put("id", u.getId());
                map.put("username", u.getUsername());
                String token = JWTUtils.generateToken(map);
                list.add(u.getId());
                return Result.success(token);
            }
            return Result.error("密码错误");
    }

    /**
     * @Author: haiYang
     * @return 返回用户信息
     */
    @GetMapping("/userInfo")
    public Result<UserInfo> userInfo(){
    Map<String, Object> map = ThreadLocalUtils.get();
    String username = (String) map.get("username");
    User u = userService.findByUsername(username);
    UserInfo userInfo = userService.getUserInfo(u.getId());
    return Result.success(userInfo);
    }

    /**
     *
     * @param userInfo 前端传入的数据
     * @return 返回成功消息
     */
    @PutMapping("/update")
    public Result<Void> update(@RequestBody @Validated UserInfo userInfo){
        userService.update(userInfo);
        return Result.success();
    }

    @PatchMapping("updateAvatar")
    public Result<String> updateAvatar(@RequestParam("avatar") @URL String avatar){
        Map<String, Object> m = ThreadLocalUtils.get();
        Integer id = (Integer) m.get("id");
        userService.updateAvatar(id,avatar);
        return Result.success("头像修改成功!");
    }

    @PatchMapping("/updatePwd")
    public Result<String> updatePwd(@RequestBody Map<String, Object> map){
        String oldPwd = (String) map.get("oldPwd");
        String newPwd = (String) map.get("newPwd");
        String rePwd = (String) map.get("rePwd");
        if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd)  || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要的参数!");
        }
        Map<String, Object> m = ThreadLocalUtils.get();
        String username = (String) m.get("username");
        User loginUser = userService.findByUsername(username);
        if (!oldPwd.equals(loginUser.getPassword())){
            return Result.error("旧密码输入错误!");
        }
        if(!newPwd.equals(rePwd)){
            return Result.error("两次输入的密码不一致!");
        }
        userService.updatePwd(newPwd);
        return Result.success("密码修改成功!");
    }

}
