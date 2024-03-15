package com.codeCart.service.impl;

import com.codeCart.mapper.UserInfoMapper;
import com.codeCart.pojo.UserInfo;
import com.codeCart.service.UserInfoService;
import com.codeCart.util.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public UserInfo getUserInfo(Integer id) {
        return userInfoMapper.getUserInfo(id);
    }

    /**
     * @param id
     */
    @Override
    public void updateUserInfoLoginTime(Integer id) {
        userInfoMapper.updateUserInfoLoginTime(id);
    }

    /**
     * @param userInfo
     */
    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateUserInfo(userInfo);
    }

    /**
     * @param avatar
     */
    @Override
    public void updateUserInfoAvatar(String avatar) {
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> id = ThreadLocalUtils.get();
        Integer userId = (Integer) id.get("id");
        map.put("id",userId);
        map.put("avatar",avatar);
        userInfoMapper.updateUserInfoAvatar(map);
    }

    /**
     * @param id
     */
    @Override
    public void updateUserInfoRegistrationTime(Integer id) {
        userInfoMapper.updateUserInfoRegistrationTime(id);
    }

    /**
     * @param id
     */
    @Override
    public void updateUserInfoPwdModifyTime(Integer id) {
        userInfoMapper.updateUserInfoPwdModifyTime(id);
    }

}
