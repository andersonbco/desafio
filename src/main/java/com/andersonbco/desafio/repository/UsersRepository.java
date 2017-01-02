package com.andersonbco.desafio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonbco.desafio.domain.User;

public interface UsersRepository extends JpaRepository<User, String>{

	public User findByEmailIgnoreCase(String email);
	
	public User findByToken(UUID token);
}
