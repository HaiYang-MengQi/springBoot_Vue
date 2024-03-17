package com.codeCart.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
public class UserDTO {
    @NotEmpty(groups = {Default.class,Registration.class})
    @Pattern(regexp = "^\\S{4,10}$",groups = {Default.class,Registration.class})
    private String username;
    @NotEmpty(groups = {Default.class,Registration.class})
    @Pattern(regexp = "^\\S{8,16}$")
    private String password;
    @NotEmpty(groups = {Registration.class})
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$",groups = {Registration.class})
    private String phone;
    public interface Registration {}
}
