package com.example.toylabs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class ToyLabsApplication

fun main(args: Array<String>) {
    runApplication<ToyLabsApplication>(*args)
}
