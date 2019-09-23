
package com.andersonbco.desafio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonbco.desafio.domain.User;

@Repository
public interface UsersRepository extends JpaRepository<User, UUID> {

  User findByEmailIgnoreCase(String email);

  User findByToken(UUID token);
}
