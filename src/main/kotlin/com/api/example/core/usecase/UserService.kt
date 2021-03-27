package com.api.example.core.usecase

import com.api.example.core.entity.User
import java.util.*

interface UserService {
    fun save(user: User)
    fun getById(id: UUID): User
    fun getAll(): List<User>
}