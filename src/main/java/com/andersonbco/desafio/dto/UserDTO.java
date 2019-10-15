
package com.andersonbco.desafio.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserDTO {

  private UUID id;

  private String name;

  private String email;

  private String password;

  private List<PhoneDTO> phones;

  @JsonFormat(
      pattern = "dd-MM-yyyy")
  @DateTimeFormat(
      iso = DateTimeFormat.ISO.TIME)
  private LocalDateTime created;

  @JsonFormat(
      pattern = "dd-MM-yyyy")
  @DateTimeFormat(
      iso = DateTimeFormat.ISO.TIME)
  private LocalDateTime modified;

  @JsonFormat(
      pattern = "dd-MM-yyyy")
  @DateTimeFormat(
      iso = DateTimeFormat.ISO.TIME)
  private LocalDateTime lastLogin;

  private UUID token;
}
