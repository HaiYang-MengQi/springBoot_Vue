package com.codeCart.service;

import com.codeCart.pojo.UserInfo;

public interface UserInfoService {
    UserInfo getUserInfo(Integer id);
    void updateUserInfoLoginTime(Integer id);
    void updateUserInfo(UserInfo userInfo);
    void updateUserInfoAvatar(String avatar);
    void updateUserInfoRegistrationTime(Integer id);
    void updateUserInfoPwdModifyTime(Integer id);
}
