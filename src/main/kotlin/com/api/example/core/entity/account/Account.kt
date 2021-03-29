package com.api.example.core.entity.account

import java.util.UUID

data class Account(val id: UUID, val account: AccountType, val userId: UUID)
