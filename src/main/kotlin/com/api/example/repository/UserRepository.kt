package com.api.example.repository

import com.api.example.core.entity.user.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : MongoRepository<User, UUID>