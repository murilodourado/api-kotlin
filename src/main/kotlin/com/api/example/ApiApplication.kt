package com.api.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(proxyBeanMethods =  false )
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}
