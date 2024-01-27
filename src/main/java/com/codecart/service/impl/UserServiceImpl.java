package com.codecart.service.impl;

import com.codecart.mapper.UserMapper;
import com.codecart.pojo.User;
import com.codecart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

//todo 用rsa加密               password = RsaUtils.encryptPasswordWithRSA(password);
                userMapper.register(username,password);
    }
}
