package com.codeCart.controller;


import com.codeCart.pojo.Result;
import com.codeCart.service.UserService;
import com.codeCart.pojo.User;
import com.codeCart.util.JWTUtils;
import com.codeCart.util.ThreadLocalUtils;
import com.codeCart.websocket.WebSocket;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
    @Autowired
    private WebSocket webSocket;
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
                return Result.success(token);
            }
            return Result.error("密码错误");
    }

    /**
     * @Author: haiYang
     * @return 返回用户信息
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
     * @return 返回成功消息
     */
    @PutMapping("/update")
    public Result<Void> update(@RequestBody @Validated User user){
        System.out.println(user);
        userService.update(user);
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
        System.out.println("oldPwd:"+oldPwd+" newPwd:"+newPwd+" rePwd:"+rePwd);
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
    @PostMapping("/chat")
    public Result<String> sendMessage(HttpSession session){
        // todo 问题 : 无法使用http将用户发送消息给指定用户通信到websocket从而开启服务
        return Result.success("开始聊天!");
    }

}