package com.api.example.repository

import com.api.example.core.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : MongoRepository<User, UUID> {
}