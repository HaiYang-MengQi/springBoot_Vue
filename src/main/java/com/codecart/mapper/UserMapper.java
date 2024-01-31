package com.codecart.mapper;

import com.codecart.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User getUserByUsername(String username);
    public void register(String username,String password,String registerTime);
    public void update(User user);
}
