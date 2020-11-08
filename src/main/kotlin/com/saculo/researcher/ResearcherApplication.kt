package com.saculo.researcher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableRedisRepositories
@EnableScheduling
class ResearcherApplication {

}

fun main(args: Array<String>) {
    runApplication<ResearcherApplication>(*args)
}
