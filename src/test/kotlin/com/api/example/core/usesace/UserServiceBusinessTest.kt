package com.api.example.core.usesace

import com.api.example.core.entity.account.AccountType
import com.api.example.core.entity.user.User
import com.api.example.core.usecase.user.UserBusinessService
import com.api.example.repository.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import java.util.Optional
import java.util.UUID

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
        val userId = UUID.randomUUID();
        val expected = Optional.of(
            User(
            id = userId,
            name = "Unit Test User",
            email = "user@user.com",
            accountType = AccountType.SALARY_ACCOUNT,
            createDate = LocalDateTime.now()
        )
        )
        every { userRepository.findById(expected.get().id) } returns expected
        assertEquals(expected.get(), userBusinessService.getById(userId))
    }

}