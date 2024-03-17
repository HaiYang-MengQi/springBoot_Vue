package com.codeCart.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {
    @Pattern(regexp = "^\\S{4,10}$")
    private String username;
    @Pattern(regexp = "^\\S{8,16}$")
    private String password;
    @Pattern(regexp = "^1[3456789]\\d{9}$")
    private String phoneNum;
}
