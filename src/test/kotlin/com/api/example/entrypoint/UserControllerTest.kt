package com.api.example.user


import com.api.example.core.entity.User
import com.api.example.core.usecase.UserService
import com.api.example.entrypoint.UserController
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@WebMvcTest(UserController::class)
class UserControllerTest {

    @Autowired
    lateinit private var mockMvc: MockMvc

    @MockkBean
    lateinit private var userService: UserService

    @BeforeEach
    fun setup() {
        every { userService.getById(1L) } returns getUser()
    }

    @Test
    fun `should return user by id`() {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/user/{id}", 1L))
            .andExpect(status().isOk)
            .andReturn()
    }

    private fun getUser(): User {
        return User(0L, "test", "test@email.com", LocalDateTime.now())
    }

}