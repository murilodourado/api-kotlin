package com.api.example.entrypoint

import com.api.example.core.entity.User
import com.api.example.core.usecase.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.NoSuchElementException

@RestController
@RequestMapping("/v1/api/user")
class UserController(private val userService: UserService) {

    @PostMapping
    fun save(@RequestBody user: User): ResponseEntity<HttpStatus> {
        return try {
            this.userService.save(user)
            ResponseEntity.status(HttpStatus.CREATED).build()
        } catch (ex: RuntimeException) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}",produces = [MediaType.APPLICATION_JSON_VALUE])
    fun find(@PathVariable("id") id: UUID): ResponseEntity<User> {
        return try {
            ResponseEntity.ok(userService.getById(id))
        } catch (ex: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/all")
    fun findAllUsers(): ResponseEntity<List<User>> {
        return try {
            ResponseEntity.status(HttpStatus.OK).body(userService.getAll())
        } catch (ex: RuntimeException) {
            ResponseEntity.badRequest().body(null);
            throw ex
        }
    }
}