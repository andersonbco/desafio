package com.andersonbco.desafio.resources

import com.andersonbco.desafio.entity.User
import com.andersonbco.desafio.entity.UserDTO
import com.andersonbco.desafio.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/usuario")
class UserResource(private val userService: UserService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<UserDTO>> {
        val users: List<UserDTO> = userService.findAll()

        return ResponseEntity.ok(users)
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long): ResponseEntity<UserDTO> {
        val user: UserDTO = userService.find(id)

        return ResponseEntity.ok(user)
    }

    @PostMapping(consumes = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun save(@RequestBody userDTO: UserDTO): ResponseEntity<User> {
        val user: User = userService.save(userDTO)

        return ResponseEntity.status(HttpStatus.CREATED).body(user)
    }
}