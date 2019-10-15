
package com.andersonbco.desafio.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.andersonbco.desafio.entity.User;
import com.andersonbco.desafio.exceptions.EmailJaExistenteException;
import com.andersonbco.desafio.exceptions.NaoAutorizadoException;
import com.andersonbco.desafio.exceptions.SenhaInvalidaException;
import com.andersonbco.desafio.exceptions.SessaoInvalidaException;
import com.andersonbco.desafio.exceptions.UsuarioInvalidoException;
import com.andersonbco.desafio.exceptions.UsuarioNaoEncontradoException;
import com.andersonbco.desafio.repository.PhonesRepository;
import com.andersonbco.desafio.repository.UsersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

  private UsersRepository usersRepository;

  private PhonesRepository phonesRepository;

  public User buscar(UUID id) {

    Optional<User> optUser = usersRepository.findById(id);

    return optUser.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));
  }

  public User buscarPorToken(UUID id, String tokenString) {

    UUID token = UUID.fromString(tokenString);

    User user = usersRepository.findByToken(token);

    if (user == null) {
      throw new NaoAutorizadoException("Não autorizado");
    }

    this.buscar(id);

    if (!user.getToken().equals(token)) {
      throw new NaoAutorizadoException("Não autorizado");
    } else if (user.getLastLogin().isBefore(LocalDateTime.now().minusMinutes(30))) {
      throw new SessaoInvalidaException("Sessão inválida");
    }
    return user;
  }

  public List<User> listar() {
    return usersRepository.findAll();
  }

  public User salvar(User user) {

    if (usersRepository.findByEmailIgnoreCase(user.getEmail()) != null) {
      throw new EmailJaExistenteException("E-mail já existente");
    }

    user.setCreated(LocalDateTime.now());
    user.setModified(LocalDateTime.now());
    user.setLastLogin(LocalDateTime.now());

    user.setToken(UUID.randomUUID());

    usersRepository.save(user);

    user.getPhones().forEach(p -> {
      p.setUser(user);
      phonesRepository.save(p);
    });

    return user;
  }

  public void excluir(UUID id) {
    try {
      usersRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new UsuarioNaoEncontradoException("Usuário não encontrado");
    }
  }

  public void atualizar(User newUser) {
    User oldUser = buscar(newUser.getId());

    newUser.setCreated(oldUser.getCreated());
    newUser.setModified(LocalDateTime.now());
    newUser.setLastLogin(oldUser.getLastLogin());

    newUser.setToken(UUID.randomUUID());

    usersRepository.save(newUser);
  }

  public User efetuarLogin(User userLogin) {

    User user = usersRepository.findByEmailIgnoreCase(userLogin.getEmail());

    if (user == null) {
      throw new UsuarioInvalidoException("Usuário e/ou senha inválidos");
    } else if (!userLogin.getPassword().equalsIgnoreCase(user.getPassword())) {
      throw new SenhaInvalidaException("Usuário e/ou senha inválidos");
    }

    user.setLastLogin(LocalDateTime.now());

    return usersRepository.save(user);
  }
}
