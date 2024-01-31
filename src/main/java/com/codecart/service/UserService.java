package com.codecart.service;


import com.codecart.pojo.User;

public interface UserService {
     public User findByUsername(String username);
     public void register(String username,String password);
     public void update(User user);
}
