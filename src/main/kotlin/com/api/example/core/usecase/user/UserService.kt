package com.api.example.core.usecase.user

import com.api.example.core.entity.user.User
import java.util.UUID

interface UserService {
    fun save(user: User)
    fun getById(id: UUID): User
    fun getAll(): List<User>
}