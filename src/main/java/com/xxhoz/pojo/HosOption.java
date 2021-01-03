package com.xxhoz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HosOption {

  private long optionId;
  private String optionName;
  private String optionValues;

}
