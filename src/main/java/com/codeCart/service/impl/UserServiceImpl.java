package com.codeCart.service.impl;
import com.codeCart.RSAUtils;
import com.codeCart.mapper.UserMapper;
import com.codeCart.pojo.User;
import com.codeCart.service.UserService;
import com.codeCart.util.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public void updateLoginTime(Integer id) {
        userMapper.updateLoginTime(id);
    }

    @Override
    public void register(String username, String password) {
                // todo 需要使用加密算法
                userMapper.register(username,password);
    }
    @Override
    public void update(User user) {
                userMapper.update(user);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtils.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(newPwd,id);
    }

    @Override
    public void updateAvatar(Integer id,String avatar) {
                userMapper.updateAvatar(id,avatar);
    }
}
