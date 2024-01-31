package com.codecart.mapper;

import com.codecart.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User getUserByUsername(String username);
    public void updateLoginTime(Integer id);
    public void register(String username,String password);
    public void update(User user);
    public void updatePwd(String newPwd,Integer id);
    public void updateAvatar(Integer id,String avatar);
}
