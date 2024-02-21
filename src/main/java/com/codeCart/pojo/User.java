package com.codeCart.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
public class User {
    @NotNull
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
}
