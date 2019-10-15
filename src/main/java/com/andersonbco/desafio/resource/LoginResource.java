
package com.andersonbco.desafio.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonbco.desafio.entity.User;
import com.andersonbco.desafio.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(
    value = "/login")
@AllArgsConstructor
public class LoginResource {

  private UserService userService;

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> efetuarLogin(@RequestBody User user) {

    return ResponseEntity.status(HttpStatus.CREATED).body(userService.efetuarLogin(user));
  }
}
