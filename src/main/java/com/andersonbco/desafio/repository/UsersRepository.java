package com.andersonbco.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonbco.desafio.domain.User;

public interface UsersRepository extends JpaRepository<User, String>{

	public User findByEmailIgnoreCase(String email);
}
