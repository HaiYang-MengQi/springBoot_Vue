package com.codeCart.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

import java.util.Date;

@Data
public class Articles {
    @NotNull(groups = Update.class)
    private Integer id;
    private String title;
    @NotEmpty
    private String alias;
    @NotEmpty
    private String cateGory;
    private Date createdAt;
    private Date updatedAt;
    private Integer authorId;
    private String content;
    public interface Update{}
    public interface Add extends Default {}
}
