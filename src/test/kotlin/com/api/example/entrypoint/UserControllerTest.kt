package com.api.example.entrypoint

import com.api.example.core.entity.account.AccountType
import com.api.example.core.entity.user.User
import com.api.example.core.usecase.user.UserService
import com.api.example.entrypoint.rest.UserController
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.time.LocalDateTime
import java.util.UUID

@ExtendWith(SpringExtension::class)
@WebMvcTest(UserController::class)
class UserControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var userService: UserService

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(UserController(userService)).build()
        every { userService.getAll() } returns getUser()
    }

    @Test
    fun `should return all users`() {
        mockMvc
            .perform(
                MockMvcRequestBuilders
                    .get("/v1/api/user/all")
                    .accept(MediaType.APPLICATION_JSON_VALUE)
            )
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[*].id").exists())
            .andReturn()
    }

    private fun getUser(): List<User> {
        return listOf(
            User(UUID.randomUUID(), "test01", "test01@email.com", AccountType.SAVING_ACCOUNT, LocalDateTime.now()),
            User(UUID.randomUUID(), "test02", "test02@email.com", AccountType.SALARY_ACCOUNT, LocalDateTime.now())
        )
    }

}