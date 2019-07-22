package com.andersonbco.desafio.service

import com.andersonbco.desafio.entity.Phone
import com.andersonbco.desafio.entity.PhoneDTO
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

    fun find(id: Long): UserDTO = userRepository.findByIdOrNull(id)?.let { it -> convertUserToUserDTO(it) }
            ?: throw UsuarioNaoEncontradoException("Usuário não encontrado")

    fun findAll(): List<UserDTO> = userRepository.findAll().map { convertUserToUserDTO(it) }

    fun save(userDTO: UserDTO): User {

        val newUser: User = User(name = userDTO.name,
                email = userDTO.email,
                password = userDTO.password)

        userRepository.save(newUser)

        userDTO.phones.forEach {
            run {
                val newPhone: Phone = Phone(ddd = it.ddd, number = it.number, user = newUser)
                phoneRepository.save(newPhone)
            }
        }

        return newUser
    }

    fun convertUserToUserDTO(user: User): UserDTO {

        val phones: List<PhoneDTO> = phoneRepository.findAllByUser(user).map { PhoneDTO(it.ddd, it.number) }

        return UserDTO(user.id, user.name, user.email, user.password, phones)
    }
}