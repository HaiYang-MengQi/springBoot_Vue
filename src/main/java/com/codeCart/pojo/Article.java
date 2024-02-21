package com.codeCart.pojo;


import lombok.Data;

import java.util.Date;
@Data
public class Article {

  private Integer id;
  private String title;
  private String author;
  private String context;
  private Date createdAt;
  private Date updatedAt;
  private String description;
  private Integer artCateId;
  private Integer userId;

}
