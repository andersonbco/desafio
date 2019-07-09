package com.andersonbco.desafio.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Phone(
        @Id @GeneratedValue val id: Long? = null,
        var ddd: Int,
        var number: Int,
        @ManyToOne var user: User
)

@Entity
class User(
        @Id @GeneratedValue val id: Long? = null,
        var name: String,
        var email: String,
        var password: String,
        var created: LocalDateTime? = LocalDateTime.now(),
        var modified: LocalDateTime? = LocalDateTime.now(),
        var lastLogin: LocalDateTime? = null
)

data class UserDTO(
        val name: String,
        val email: String,
        val password: String
)