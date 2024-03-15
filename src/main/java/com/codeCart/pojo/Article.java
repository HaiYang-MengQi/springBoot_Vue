package com.codeCart.pojo;


import com.codeCart.anno.State;
import lombok.Data;

import java.util.Date;
@Data
public class Article {

  private Integer id;
  private String title;
  private String author;
  private String context;
  @State
  private String state;
  private Date createdAt;
  private Date updatedAt;
  private String description;
  private Integer artCateId;
  private Integer userId;
}
