package com.codecart.service.impl;

import com.codecart.mapper.UserMapper;
import com.codecart.pojo.User;
import com.codecart.service.UserService;
import com.codecart.util.RsaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public void register(String username, String password) throws Exception {
               password = RsaUtils.encryptPasswordWithRSA(password);
                userMapper.register(username,password);
    }
}
