package com.api.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication(proxyBeanMethods =  false )
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}
