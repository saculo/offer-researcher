package com.saculo.researcher.notification.infrastructure.configuration

import com.saculo.researcher.notification.infrastructure.adapter.EmailSender
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender

@Configuration
@EnableBinding(Sink::class)
class NotificationConfiguration {

    @Bean
    fun emailSender(email: JavaMailSender) = EmailSender(email)
}
