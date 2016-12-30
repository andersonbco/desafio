package com.andersonbco.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andersonbco.desafio.domain.User;
import com.andersonbco.desafio.repository.UsersRepository;

@RestController
public class UserResources {

	@Autowired
	private UsersRepository usersRepository;
	
	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
	public List<User> listar() {
		
		return usersRepository.findAll();
	}
	
	@RequestMapping(value="/cadastro", method=RequestMethod.POST)
	public void salvar(@RequestBody User user) {
		
		System.out.println(user.getPhones());
		usersRepository.save(user);
	}
}
