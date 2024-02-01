package com.codeCart.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

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
    private char gender;
    private byte age;
    private String address;
    @NotEmpty
    @Email
    private String email;
    private Date registrationTime;
    private Date lastLoginTime;
    private UserStatus userStatus;
    private UserType userType;
    private String phoneNumber;
    private String birthday;
    private String education;
    private String avatar;
    private Date passwordModified;
    private Long authorId;
}
