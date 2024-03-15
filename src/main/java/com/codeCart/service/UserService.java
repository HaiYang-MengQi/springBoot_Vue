package com.codeCart.service;


import com.codeCart.dto.UserDTO;
import com.codeCart.pojo.User;
import com.codeCart.pojo.UserInfo;

public interface UserService {
      User getUserByUserName(String username);
      void userRegister(UserDTO userDTO);
      void updateUserPwd(String newPwd);

}
