package com.codeCart.mapper;

import com.codeCart.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
     User getUserByUserName(String username);
     int userRegister(User user);
     void updateUserPwd(Map<String,Object> map);
}
