package com.codeCart.service.impl;
import com.codeCart.bo.UserBO;
import com.codeCart.dto.UserDTO;
import com.codeCart.mapper.UserInfoMapper;
import com.codeCart.mapper.UserMapper;
import com.codeCart.pojo.User;
import com.codeCart.pojo.UserInfo;
import com.codeCart.service.UserInfoService;
import com.codeCart.service.UserService;
import com.codeCart.util.JWTUtils;
import com.codeCart.util.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    public User getUserByUserName(String username) {
        User user = userMapper.getUserByUserName(username);
        return user;
    }
    @Override
    public void userRegister(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        UserBO userBO = new UserBO(user);
        userBO.encryptPassword();
        userMapper.userRegister(user);
        Map<String,Object> map = new HashMap<>();
        map.put("id",user.getId());
        map.put("phone",userDTO.getPhone());
        userInfoService.updateUserInfoRegistrationTime(map);
    }
    @Override
    public void updateUserPwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtils.get();
        Integer id = (Integer) map.get("id");
        Map<String,Object> pwd = new HashMap<>();
        pwd.put("id",id);
        pwd.put("newPwd",newPwd);
        userMapper.updateUserPwd(pwd);
        userInfoService.updateUserInfoPwdModifyTime(id);
    }


}
