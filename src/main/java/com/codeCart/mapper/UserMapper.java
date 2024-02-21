package com.codeCart.mapper;

import com.codeCart.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {
     User getUserByUsername(String username);
     int register(User user);
     void updatePwd(Map<String,Object> map);
}
