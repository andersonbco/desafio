package com.andersonbco.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andersonbco.desafio.domain.User;
import com.andersonbco.desafio.services.UsersService;

@RestController
public class UserResources {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
	public ResponseEntity<List<User>> listar() {
		
		return ResponseEntity.status(HttpStatus.OK).body(usersService.listar());
	}
	
	@RequestMapping(value="/cadastro/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> buscar(@PathVariable("id") String id) {
		
		return ResponseEntity.status(HttpStatus.OK).body(usersService.buscar(id));
	}
	
	@RequestMapping(value="/cadastro", method=RequestMethod.POST)
	public ResponseEntity<User> salvar(@RequestBody User user) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.salvar(user));
	}

	@RequestMapping(value="/cadastro/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<User> deletar(@PathVariable("id") String id) {
		
		usersService.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@RequestMapping(value="/cadastro/{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> atualizar(@RequestBody User user, @PathVariable("id") String id) {
		
		user.setId(id);
		usersService.atualizar(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
