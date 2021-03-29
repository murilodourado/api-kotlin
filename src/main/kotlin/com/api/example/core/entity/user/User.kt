package com.api.example.core.entity.user

import com.api.example.core.entity.account.AccountType
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.UUID

data class User(
    @Id val id: UUID,
    val name: String,
    val email: String,
            val accountType: AccountType,
    val createDate: LocalDateTime = LocalDateTime.now()
)