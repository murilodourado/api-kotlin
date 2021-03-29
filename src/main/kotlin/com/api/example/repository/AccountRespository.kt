package com.api.example.repository

import com.api.example.core.entity.account.Account
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface AccountRespository : MongoRepository<Account, UUID> {
    fun findByUserId(id: UUID): Account
}