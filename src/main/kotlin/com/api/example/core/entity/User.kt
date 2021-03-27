package com.api.example.core.entity

import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*

data class User(
    @Id val id: UUID,
    val name: String,
    val email: String,
    val createDate: LocalDateTime = LocalDateTime.now()
)