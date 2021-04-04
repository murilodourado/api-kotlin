package com.api.example.core.entity.account

import org.springframework.data.annotation.Id
import java.util.UUID

data class Account(@Id val account: AccountType, val userId: UUID)
