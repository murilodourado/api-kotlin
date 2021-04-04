package com.api.example.entrypoint.kafka

import com.api.example.config.KafkaConfig.Topics.Companion.EVENT_USER_CREATED
import com.api.example.core.entity.account.Account
import com.api.example.core.entity.user.User
import com.api.example.core.usecase.account.AccountService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class CreateUserAccountMDB(private val accountService: AccountService, val objectMapper: ObjectMapper) {

    @KafkaListener(groupId = EVENT_USER_CREATED, topics = [EVENT_USER_CREATED])
    fun consume(userPayload: String) {
        val user = objectMapper.readValue(userPayload, User::class.java)
        accountService.create(Account(user.accountType, user.id))
    }
}