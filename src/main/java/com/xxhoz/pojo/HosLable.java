package com.xxhoz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosLable {

  private Long lableId;
  private String lableName;
  private String labelDescription;
  private String labelAlias;

}
