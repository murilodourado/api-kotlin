package com.api.example.entrypoint.rest

import com.api.example.core.usecase.account.AccountService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1/api/account")
class AccountController(private val accountService: AccountService) {

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable("id") id : UUID) : ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(accountService.getByUserId(id))
        } catch (ex : RuntimeException) {
            ResponseEntity.badRequest().build()
        }
    }
}