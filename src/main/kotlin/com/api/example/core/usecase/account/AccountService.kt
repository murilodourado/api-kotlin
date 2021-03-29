package com.api.example.core.usecase.account

import com.api.example.core.entity.account.Account
import java.util.UUID

interface AccountService {
    fun create(account: Account)
    fun getByUserId(id: UUID) : Account
}