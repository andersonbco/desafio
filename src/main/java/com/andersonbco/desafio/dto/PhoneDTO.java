
package com.andersonbco.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PhoneDTO {

  @JsonProperty("number")
  private Integer phoneNumber;

  private Integer ddd;
}
