
package com.andersonbco.desafio.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class User {

  @Id
  @GeneratedValue(
      generator = "custom-id")
  @GenericGenerator(
      name = "custom-id",
      strategy = "org.hibernate.id.UUIDGenerator")
  @Column(
      columnDefinition = "BINARY(16)")
  private UUID id;

  private String name;

  private String email;

  private String password;

  @OneToMany(
      mappedBy = "user",
      cascade = CascadeType.REMOVE,
      orphanRemoval = true)
  private List<Phone> phones;

  private LocalDateTime created;

  private LocalDateTime modified;

  private LocalDateTime lastLogin;

  private UUID token;
}
