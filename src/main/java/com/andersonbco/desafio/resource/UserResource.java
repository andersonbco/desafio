
package com.andersonbco.desafio.resource;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andersonbco.desafio.dto.UserDTO;
import com.andersonbco.desafio.entity.User;
import com.andersonbco.desafio.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(
    value = "/cadastro")
@AllArgsConstructor
public class UserResource {

  private UserService userService;

  private ModelMapper mapper;

  @GetMapping(
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<UserDTO>> listar() {

    return ResponseEntity.status(HttpStatus.OK).body(userService.listar().stream()
        .map(m -> mapper.map(m, UserDTO.class)).collect(Collectors.toList()));
  }

  @GetMapping(
      value = "/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDTO> buscar(@PathVariable("id") UUID id, @RequestHeader(
      value = "token") String tokenString) {

    return ResponseEntity.status(HttpStatus.OK)
        .body(mapper.map(userService.buscarPorToken(id, tokenString), UserDTO.class));
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDTO> salvar(@RequestBody User user) {

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(mapper.map(userService.salvar(user), UserDTO.class));
  }

  @DeleteMapping(
      value = "/{id}")
  public ResponseEntity<UserDTO> deletar(@PathVariable("id") UUID id) {

    userService.excluir(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PutMapping(
      value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> atualizar(@RequestBody User user, @PathVariable("id") UUID id) {

    user.setId(id);
    userService.atualizar(user);
    return ResponseEntity.status(HttpStatus.OK).body(user);
  }
}
