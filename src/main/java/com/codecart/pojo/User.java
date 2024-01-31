package com.codecart.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class User {
    @NotNull
    private Integer id;
    @NotEmpty
    private String name;
    private String username;
    @JsonIgnore
    private String password;
    private String avatar;
    private char gender;
    private byte age;
    private String address;
    @NotEmpty
    @Email
    private String email;
    private String registration_time;
    private String last_login_time;
    private UserStatus user_status;
    private UserType user_type;
    private String phone_number;
    private String birthday;
    private String education;
}
