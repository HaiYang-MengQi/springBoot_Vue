package com.codeCart.mapper;

import com.codeCart.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserInfoMapper {
    UserInfo getUserInfobyId(Integer id);
    void insertRegistrationTime(Integer id);
    void updateLoginTime(Integer id);
    void update(UserInfo userInfo);
    void updateAvatar(Map<String,Object> map);
    void updatePwdTime(Integer id);
}
