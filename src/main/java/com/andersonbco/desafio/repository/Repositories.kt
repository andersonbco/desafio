package com.andersonbco.desafio.repository

import com.andersonbco.desafio.entity.Phone
import com.andersonbco.desafio.entity.User
import org.springframework.data.repository.CrudRepository

interface PhoneRepository : CrudRepository<Phone, Long> {
    fun findAllByUser(user: User): List<Phone>
}

interface UserRepository : CrudRepository<User, Long> {
    fun findByEmailIgnoreCase(email: String): User
}