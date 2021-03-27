package com.api.example.core.usecase

import com.api.example.core.entity.User
import com.api.example.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserBusinessService(private val userRepository: UserRepository) : UserService {

    override fun save(user: User) {
        userRepository.save(user)
    }

    override fun getById(id: UUID): User {
        return userRepository.findById(id).get();
    }

    override fun getAll(): List<User> = userRepository.findAll().toList();
}