
package com.andersonbco.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonbco.desafio.domain.Phone;

@Repository
public interface PhonesRepository extends JpaRepository<Phone, String> {

}
