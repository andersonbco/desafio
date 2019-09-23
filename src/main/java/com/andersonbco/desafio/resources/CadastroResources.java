package com.andersonbco.desafio.resources;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andersonbco.desafio.domain.User;
import com.andersonbco.desafio.services.UsersService;
import com.andersonbco.desafio.services.exceptions.NaoAutorizadoException;
import com.andersonbco.desafio.services.exceptions.SessaoInvalidaException;
import com.andersonbco.desafio.services.exceptions.TokenInvalidoException;

@RestController
@RequestMapping(value="/cadastro")
public class CadastroResources {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listar() {
		
		return ResponseEntity.status(HttpStatus.OK).body(usersService.listar());
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> buscar(@PathVariable("id") UUID id, @RequestHeader(value="token") String tokenString) {
		
		UUID token;
		try {
			token = UUID.fromString(tokenString);
		} catch (IllegalArgumentException e) {
			throw new TokenInvalidoException("Token inválido");
		}
		usersService.buscarPorToken(token);
		
		User user = usersService.buscar(id);
		
		if(!user.getToken().equals(token))
			throw new NaoAutorizadoException("Não autorizado");
		else if(user.getLast_login().isBefore(LocalDateTime.now().minusMinutes(30)))
			throw new SessaoInvalidaException("Sessão inválida");
			
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> salvar(@RequestBody User user) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.salvar(user));
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<User> deletar(@PathVariable("id") UUID id) {
		
		usersService.excluir(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> atualizar(@RequestBody User user, @PathVariable("id") UUID id) {
		
		user.setId(id);
		usersService.atualizar(user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
