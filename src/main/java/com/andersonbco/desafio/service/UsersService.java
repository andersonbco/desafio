//package com.andersonbco.desafio.service;
//
//import com.andersonbco.desafio.domain.Phone;
//import com.andersonbco.desafio.domain.User;
//import com.andersonbco.desafio.repository.PhonesRepository;
//import com.andersonbco.desafio.repository.UsersRepository;
//import com.andersonbco.desafio.service.exceptions.EmailJaExistenteException;
//import com.andersonbco.desafio.service.exceptions.NaoAutorizadoException;
//import com.andersonbco.desafio.service.exceptions.SenhaInvalidaException;
//import com.andersonbco.desafio.service.exceptions.UsuarioInvalidoException;
//import com.andersonbco.desafio.service.exceptions.UsuarioNaoEncontradoException;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UsersService {
//
//  @Autowired private UsersRepository usersRepository;
//
//  @Autowired private PhonesRepository phonesRepository;
//
//  public User buscar(String id) {
//
//    Optional<User> optUser = usersRepository.findById(id);
//
//    return optUser.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));
//  }
//
//  public User buscarPorToken(UUID token) {
//
//    User user = usersRepository.findByToken(token);
//
//    if (user == null) {
//      throw new NaoAutorizadoException("Não autorizado");
//    }
//
//    return user;
//  }
//
//  public List<User> listar() {
//    return usersRepository.findAll();
//  }
//
//  public User salvar(User user) {
//
//    if (usersRepository.findByEmailIgnoreCase(user.getEmail()) != null) {
//      throw new EmailJaExistenteException("E-mail já existente");
//    }
//
//    user.setCreated(LocalDateTime.now());
//    user.setModified(LocalDateTime.now());
//    user.setLast_login(LocalDateTime.now());
//
//    user.setToken(UUID.randomUUID());
//
//    usersRepository.save(user);
//
//    for (Phone p : user.getPhones()) {
//      p.setUser(user);
//      phonesRepository.save(p);
//    }
//
//    return user;
//  }
//
//  public void excluir(String id) {
//    try {
//      usersRepository.deleteById(id);
//    } catch (EmptyResultDataAccessException e) {
//      throw new UsuarioNaoEncontradoException("Usuário não encontrado");
//    }
//  }
//
//  public void atualizar(User newUser) {
//    User oldUser = buscar(newUser.getId());
//
//    newUser.setCreated(oldUser.getCreated());
//    newUser.setModified(LocalDateTime.now());
//    newUser.setLast_login(oldUser.getLast_login());
//
//    newUser.setToken(UUID.randomUUID());
//
//    usersRepository.save(newUser);
//  }
//
//  public User efetuarLogin(User userLogin) {
//
//    User user = usersRepository.findByEmailIgnoreCase(userLogin.getEmail());
//
//    if (user == null) {
//      throw new UsuarioInvalidoException("Usuário e/ou senha inválidos");
//    } else if (!userLogin.getPassword().equalsIgnoreCase(user.getPassword())) {
//      throw new SenhaInvalidaException("Usuário e/ou senha inválidos");
//    }
//
//    user.setLast_login(LocalDateTime.now());
//
//    return usersRepository.save(user);
//  }
//}
