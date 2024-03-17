package com.codeCart.service;

import com.codeCart.pojo.UserInfo;

import java.util.Map;

public interface UserInfoService {
    UserInfo getUserInfo(Integer id);
    void updateUserInfoLoginTime(Integer id);
    void updateUserInfo(UserInfo userInfo);
    void updateUserInfoAvatar(String avatar);
        void updateUserInfoRegistrationTime(Map<String,Object> map);
    void updateUserInfoPwdModifyTime(Integer id);
}
