package com.codeCart.pojo;
import lombok.Data;
import java.util.Date;
@Data

public class Comment {
  private Integer id;
  private Integer userId;
  private String words;
  private Date createdAt;
}
