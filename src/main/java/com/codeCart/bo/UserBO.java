package com.codeCart.bo;

import com.codeCart.pojo.User;
import com.codeCart.util.BCryptUtils;

public class UserBO {
    private User user;

    public UserBO(User user) {
        this.user = user;
    }

    // 可以在这里添加业务方法，比如密码加密、校验等
    public void encryptPassword() {
        if(this.user != null){
            this.user.setPassword(BCryptUtils.encrypt(this.user.getPassword()));
        }
    }

}
