package com.andersonbco.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonbco.desafio.domain.Phone;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<Phone, String>{

}
