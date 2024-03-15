package com.codeCart.mapper;

import com.codeCart.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserInfoMapper {
    UserInfo getUserInfo(Integer id);
    void updateUserInfoLoginTime(Integer id);
    void updateUserInfo(UserInfo userInfo);
    void updateUserInfoAvatar(Map<String,Object> map);
    void updateUserInfoRegistrationTime(Integer id);
    void updateUserInfoPwdModifyTime(Integer id);
}
