package com.api.example.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig {

    @Bean
    fun userCreateTopic(): NewTopic {
        return TopicBuilder.name(Topics.EVENT_USER_CREATED).build()
    }

    class Topics {
        companion object {
            const val EVENT_USER_CREATED = "event.user"
        }
    }

}