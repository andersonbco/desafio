package com.andersonbco.desafio.repository

import com.andersonbco.desafio.entity.Phone
import com.andersonbco.desafio.entity.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val phoneRepository: PhoneRepository,
        val userRepository: UserRepository) {

    private lateinit var user1: User
    private lateinit var phone1: Phone
    private lateinit var phone2: Phone

    @Test
    fun `When findByEmailIgnoreCase then return User`() {
        user1 = User(name = "Teste", email = "teste@email.com", password = "senha")
        entityManager.persist(user1)
        entityManager.flush()
        val found = userRepository.findByEmailIgnoreCase(user1.email)
        assertThat(found).isEqualTo(user1)
    }

    @Test
    fun `When findAllByUser then return Phones`() {
        user1 = User(name = "Teste", email = "teste@email.com", password = "senha")
        entityManager.persist(user1)
        phone1 = Phone(ddd = 21, number = 999999999, user = user1)
        phone2 = Phone(ddd = 11, number = 888888888, user = user1)
        entityManager.persist(phone1)
        entityManager.persist(phone2)
        entityManager.flush()
        val found = phoneRepository.findAllByUser(user1)
        assertThat(found).containsAll(listOf(phone1, phone2))
    }
}