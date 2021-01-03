package com.xxhoz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosUser {

  private long userId;
  private String userName;
  private String userPassword;
  private String userNickname;
  private String userMail;
  private java.sql.Timestamp userRegistrationTime;
  private String userProfilePhoto;

}
