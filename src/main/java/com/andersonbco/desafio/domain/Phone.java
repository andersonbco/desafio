
package com.andersonbco.desafio.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Phone {

  @Id
  @GeneratedValue(
      generator = "custom-id")
  @GenericGenerator(
      name = "custom-id",
      strategy = "org.hibernate.id.UUIDGenerator")
  @Column(
      columnDefinition = "BINARY(16)")
  @JsonIgnore
  private UUID id;

  private Integer number;

  private Integer ddd;

  @ManyToOne(
      fetch = FetchType.LAZY)
  @JoinColumn(
      name = "USER_ID")
  @JsonIgnore
  private User user;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Integer getDdd() {
    return ddd;
  }

  public void setDdd(Integer ddd) {
    this.ddd = ddd;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
