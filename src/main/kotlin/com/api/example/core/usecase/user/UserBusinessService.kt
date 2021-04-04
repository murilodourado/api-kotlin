package com.api.example.core.usecase.user

import com.api.example.config.KafkaConfig.Topics.Companion.EVENT_USER_CREATED
import com.api.example.core.entity.user.User
import com.api.example.repository.UserRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.KafkaException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserBusinessService(
    private val userRepository: UserRepository,
    private val objectMapper: ObjectMapper
) : UserService {

    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    override fun save(user: User) {
        kafkaTemplate?.send(ProducerRecord(EVENT_USER_CREATED, objectMapper.writeValueAsString(user)))
            ?.addCallback({
                userRepository.save(user)
            }, {
                throw KafkaException(String.format("ERROR TO PRODUCE MESSAGE: %s", it.message))
            })
    }

    override fun getById(id: UUID): User {
        return userRepository.findById(id).get()
    }

    override fun getAll(): List<User> = userRepository.findAll().toList();
}