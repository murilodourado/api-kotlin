package com.api.example.core.usesace

import com.api.example.core.entity.User
import com.api.example.core.usecase.UserBusinessService
import com.api.example.repository.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import java.util.*

@SpringBootTest
class UserServiceBusinessTest {

    @MockK
    private lateinit var userRepository: UserRepository

    @InjectMockKs
    private lateinit var userBusinessService: UserBusinessService

    @BeforeEach
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun `should return user by id`() {
        val expected = Optional.of(User(
            id = 0L,
            name = "Unit Test User",
            email = "user@user.com",
            createDate = LocalDateTime.now()
        ))
        every { userRepository.findById(expected.get().id) } returns expected

        Assertions.assertEquals(expected.get(), userBusinessService.getById(0L))
    }

}