
package com.andersonbco.desafio.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
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
  private UUID id;

  private Integer number;

  private Integer ddd;

  @ManyToOne(
      fetch = FetchType.LAZY)
  @JoinColumn(
      name = "USER_ID")
  private User user;
}
