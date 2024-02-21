package com.codeCart.service;


import com.codeCart.pojo.User;
import com.codeCart.pojo.UserInfo;

public interface UserService {
      User findByUsername(String username);
      UserInfo getUserInfo(Integer id);
      void register(String username,String password);
      void updatePwd(String newPwd);
      void updateLoginTime(Integer id);
      void update(UserInfo userInfo);
      void updateAvatar(Integer id,String avatar);
}
