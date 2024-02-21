package com.codeCart.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    @NotEmpty
    private String name;
    private char gender;
    private byte age;
    private String address;
    @NotEmpty
    @Email
    private String email;
    private Date registrationTime;
    private Date lastLoginTime;
    private UserStatus userStatus;
    private String phoneNumber;
    private String birthday;
    private String education;
    private String avatar;
    private Date passwordModified;
    private Integer userId;
}
