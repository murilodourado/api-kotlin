package com.api.example.core.usecase

import com.api.example.core.entity.User

interface UserService {
    fun save(user: User)
    fun getById(id: Long): User
    fun getAll(): List<User>
}