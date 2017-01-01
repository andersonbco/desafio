package com.andersonbco.desafio.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.andersonbco.desafio.domain.Phone;
import com.andersonbco.desafio.domain.User;
import com.andersonbco.desafio.repository.PhonesRepository;
import com.andersonbco.desafio.repository.UsersRepository;
import com.andersonbco.desafio.services.exceptions.EmailJaExistenteException;
import com.andersonbco.desafio.services.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PhonesRepository phonesRepository;
	
	public User buscar(String id) {
		
		User user = usersRepository.findOne(id);
		
		if(user == null)
			throw new UsuarioNaoEncontradoException("Usuário não encontrado");
			
		return user;
	}

	public List<User> listar() {
		return usersRepository.findAll();
	}
	
	public User salvar(User user) {
		
		if(usersRepository.findByEmailIgnoreCase(user.getEmail()) != null)
			throw new EmailJaExistenteException("E-mail já existente");
			
		user.setCreated   (LocalDateTime.now());
		user.setModified  (LocalDateTime.now());
		user.setLast_login(LocalDateTime.now());
		
		usersRepository.save(user);
		
		for(Phone p : user.getPhones()) {
			p.setUser(user);
			phonesRepository.save(p);
		}
		
		return user;
	}
	
	public void excluir(String id) {
		try {
			usersRepository.delete(id);
		} catch(EmptyResultDataAccessException e) {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado");
		}
	}
	
	public void atualizar(User newUser) {
		User oldUser = buscar(newUser.getId());
		
		newUser.setCreated(oldUser.getCreated());
		newUser.setModified(LocalDateTime.now());
		newUser.setLast_login(oldUser.getLast_login());
		
		usersRepository.save(newUser);
	}
}