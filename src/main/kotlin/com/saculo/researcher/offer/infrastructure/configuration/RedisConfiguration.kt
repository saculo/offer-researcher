package com.saculo.researcher.offer.infrastructure.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfiguration {
    @Bean
    fun connection(): LettuceConnectionFactory {
        val lettuceConnectionFactory = LettuceConnectionFactory()
        lettuceConnectionFactory.hostName = "redis"
        lettuceConnectionFactory.port = 6379

        return lettuceConnectionFactory
    }

    @Bean
    fun redis(): RedisTemplate<String, Any> {
        val template: RedisTemplate<String, Any>  = RedisTemplate()
        template.setConnectionFactory(connection())

        return template
    }

}
