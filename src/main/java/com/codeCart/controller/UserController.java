package com.codeCart.controller;


import com.codeCart.dto.UserDTO;
import com.codeCart.pojo.Result;
import com.codeCart.pojo.User;
import com.codeCart.pojo.UserInfo;
import com.codeCart.service.UserInfoService;
import com.codeCart.service.UserService;
import com.codeCart.util.BCryptUtils;
import com.codeCart.util.JWTUtils;
import com.codeCart.util.ThreadLocalUtils;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private UserInfoService userInfoService;
    /**
     * @Author: haiYang
     * @param userDTO DTO对象
     * @Patten 代表匹配正则表达式
     * @return 返回JWT令牌
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody @Validated UserDTO userDTO)  {
        //通过查询用户是否存在
        User u = userService.getUserByUserName(userDTO.getUsername());
        if(u == null){
            return Result.error("用户名错误");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(userDTO.getPassword(),u.getPassword())){
            userInfoService.updateUserInfoLoginTime(u.getId());
            String token = JWTUtils.generateToken(u.getId(),u.getUsername());
            return Result.success(token);
        }
        return Result.error("密码错误");
    }
    @PostMapping("/register")
    public Result<String> userRegister(@RequestBody @Validated UserDTO userDTO)  {
        User u = userService.getUserByUserName(userDTO.getUsername());
        if (u == null) {
            userService.userRegister(userDTO);
            return Result.success("注册成功!现在您可以登录了");
        } else {
            return Result.error("用户已存在");
        }
    }
    @PatchMapping("/updatePwd")
    public Result<String> updateUserPwd(@RequestBody Map<String, Object> map){
        String oldPwd = (String) map.get("oldPwd");
        String newPwd = (String) map.get("newPwd");
        String rePwd = (String) map.get("rePwd");
        if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd)  || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要的参数!");
        }
        Map<String, Object> m = ThreadLocalUtils.get();
        String username = (String) m.get("username");
        User u = userService.getUserByUserName(username);
        if (!oldPwd.equals(u.getPassword())){
            return Result.error("旧密码输入错误!");
        }
        if(!newPwd.equals(rePwd)){
            return Result.error("两次输入的密码不一致!");
        }
        userService.updateUserPwd(newPwd);
        return Result.success("密码修改成功!");
    }
    /**
     * @Author: haiYang
     * @return 返回用户信息
     */
    @GetMapping("/userInfo")
    public Result<UserInfo> getUserInfo(){
    Map<String, Object> map = ThreadLocalUtils.get();
    Integer id = (Integer) map.get("id");
    UserInfo userInfo = userInfoService.getUserInfo(id);
    return Result.success(userInfo);
    }

    /**
     *
     * @param userInfo 前端传入的数据
     * @return 返回成功消息
     */
    @PutMapping("/update")
    public Result<Void> updateUserInfo(@RequestBody @Validated UserInfo userInfo){
        userInfoService.updateUserInfo(userInfo);
        return Result.success();
    }
    @PatchMapping("updateAvatar")
    public Result<String> updateUserInfoAvatar(@RequestParam("avatar") @URL String avatar){
        userInfoService.updateUserInfoAvatar(avatar);
        return Result.success("头像修改成功!");
    }
}
