package com.api.example.core.usecase.account

import com.api.example.core.entity.account.Account
import com.api.example.repository.AccountRespository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AccountBusinessService(private val accountRepository: AccountRespository) : AccountService {

    override fun create(account: Account) {
        accountRepository.save(account)
    }

    override fun getByUserId(id: UUID) : Account {
        return accountRepository.findByUserId(id)
    }

}