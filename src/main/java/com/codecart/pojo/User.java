package com.codecart.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private char gender;
    @JsonIgnore
    private byte age;
    @JsonIgnore
    private String address;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private LocalDateTime registration_time;
    @JsonIgnore
    private LocalDateTime last_login_time;
    @JsonIgnore
    private UserStatus status;
    @JsonIgnore
    private UserType type;
    @JsonIgnore
    private String phone_number;
    @JsonIgnore
    private Date birthday;
    @JsonIgnore
    private String education;
}
