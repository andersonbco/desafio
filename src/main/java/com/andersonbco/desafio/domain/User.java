
package com.andersonbco.desafio.domain;

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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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

  public User() {
  }

  public User(String name) {
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public LocalDateTime getModified() {
    return modified;
  }

  public void setModified(LocalDateTime modified) {
    this.modified = modified;
  }

  public LocalDateTime getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(LocalDateTime lastLogin) {
    this.lastLogin = lastLogin;
  }

  public UUID getToken() {
    return token;
  }

  public void setToken(UUID token) {
    this.token = token;
  }

}
