package com.codecart.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private char gender;
    private byte age;
    private String address;
    private String email;
    private LocalDateTime registration_time;
    private LocalDateTime last_login_time;
    private UserStatus status;
    private UserType type;
    private String phone_number;
    private Date birthday;
    private String education;
}
