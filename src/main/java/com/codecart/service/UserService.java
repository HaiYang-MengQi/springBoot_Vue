package com.codecart.service;


import com.codecart.pojo.User;

public interface UserService {
     public User findByUsername(String username);
     public void updateLoginTime(Integer id);
     public void register(String username,String password);
     public void update(User user);
     public void updatePwd(String newPwd);
     public void updateAvatar(Integer id,String avatar);
}
