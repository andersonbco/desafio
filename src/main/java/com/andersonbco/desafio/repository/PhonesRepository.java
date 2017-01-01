package com.andersonbco.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonbco.desafio.domain.Phone;

public interface PhonesRepository extends JpaRepository<Phone, String>{

}
