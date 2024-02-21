package com.codeCart.pojo;


import lombok.Data;

import java.util.Date;
@Data
public class ArticleCategories {
  private Integer id;
  private String type;
  private String alias;
  private String description;
  private Date createdAt;
  private Date updatedAt;
  private Integer createdBy;
}
