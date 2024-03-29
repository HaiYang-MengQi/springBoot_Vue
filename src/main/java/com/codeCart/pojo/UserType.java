package com.codeCart.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserType {
  private long id;
  private String type;
  private Date createdAt;
  private Date updatedAt;
}
