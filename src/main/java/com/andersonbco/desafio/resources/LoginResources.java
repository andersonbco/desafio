
package com.andersonbco.desafio.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andersonbco.desafio.domain.User;
import com.andersonbco.desafio.services.UsersService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(
    value = "/login")
@AllArgsConstructor
public class LoginResources {

  private UsersService usersService;

  @RequestMapping(
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> efetuarLogin(@RequestBody User user) {

    return ResponseEntity.status(HttpStatus.CREATED).body(usersService.efetuarLogin(user));
  }
}
