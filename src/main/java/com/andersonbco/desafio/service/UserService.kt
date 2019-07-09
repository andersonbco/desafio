package com.andersonbco.desafio.service

import com.andersonbco.desafio.entity.User
import com.andersonbco.desafio.entity.UserDTO
import com.andersonbco.desafio.repository.PhoneRepository
import com.andersonbco.desafio.repository.UserRepository
import com.andersonbco.desafio.service.exceptions.UsuarioNaoEncontradoException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository,
        private val phoneRepository: PhoneRepository) {

    fun find(id: Long): User = userRepository.findByIdOrNull(id)
            ?: throw UsuarioNaoEncontradoException("Usuário não encontrado")

    fun findAll(): List<User> = userRepository.findAll().toList()

    fun save(userDTO: UserDTO): User {

        val newUser: User = User(name = userDTO.name,
                email = userDTO.email,
                password = userDTO.password)

        return userRepository.save(newUser)
    }


}