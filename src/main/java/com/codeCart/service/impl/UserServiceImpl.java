package com.codeCart.service.impl;
import com.codeCart.mapper.UserInfoMapper;
import com.codeCart.mapper.UserMapper;
import com.codeCart.pojo.User;
import com.codeCart.pojo.UserInfo;
import com.codeCart.service.UserService;
import com.codeCart.util.LocalDataUtils;
import com.codeCart.util.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public User findByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public UserInfo getUserInfo(Integer id) {
        return userInfoMapper.getUserInfobyId(id);
    }

    @Override
    public void register(String username, String password) {
                // todo 需要使用加密算法
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.register(user);
        userInfoMapper.insertRegistrationTime(user.getId());
    }
    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtils.get();
        Integer id = (Integer) map.get("id");
        Map<String,Object> pwd = new HashMap<>();
        pwd.put("id",id);
        pwd.put("newPwd",newPwd);
        userMapper.updatePwd(pwd);
        userInfoMapper.updatePwdTime(id);
    }

    @Override
    public void updateLoginTime(Integer id) {
        userInfoMapper.updateLoginTime(id);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfoMapper.update(userInfo);
    }

    @Override
    public void updateAvatar(String avatar) {
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> id = ThreadLocalUtils.get();
        Integer userId = (Integer) id.get("id");
        map.put("id",userId);
        map.put("avatar",avatar);
        userInfoMapper.updateAvatar(map);
    }
}
