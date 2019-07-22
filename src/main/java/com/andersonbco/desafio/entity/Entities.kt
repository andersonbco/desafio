package com.andersonbco.desafio.entity

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
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
        @JsonFormat(pattern = "dd-MM-yyyy") var created: LocalDateTime? = LocalDateTime.now(),
        @JsonFormat(pattern = "dd-MM-yyyy") var modified: LocalDateTime? = LocalDateTime.now(),
        @JsonFormat(pattern = "dd-MM-yyyy") @JsonProperty("last_login") var lastLogin: LocalDateTime? = LocalDateTime.now()
)

data class UserDTO(
        val name: String,
        val email: String,
        val password: String,
        val phones: List<PhoneDTO>
)

data class PhoneDTO(
        val ddd: Int,
        val number: Int
)