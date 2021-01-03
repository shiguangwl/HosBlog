package com.xxhoz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosComments {

  private Long commentId;
  private String commentUserName;
  private String commentEmail;
  private String commentContent;
  private java.sql.Timestamp commentTime;
  private long commentLikeCount;
  private long parentCommentId;
  private long articleId;

}
