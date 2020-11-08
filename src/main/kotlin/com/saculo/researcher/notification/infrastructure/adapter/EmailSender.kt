package com.saculo.researcher.notification.infrastructure.adapter

import com.saculo.researcher.notification.domain.Message
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender

class EmailSender(private val emailSender: JavaMailSender) {
    val LOGGER: Logger = LoggerFactory.getLogger(EmailSender::class.java)

    @StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'notification-offers'")
    fun send(message: Message) {
        val messageToSend = SimpleMailMessage()
        messageToSend.setTo(message.receiver)
        messageToSend.setSubject(message.subject)
        messageToSend.setText(message.body)
        LOGGER.debug(message.body)
        LOGGER.debug(message.receiver)
        LOGGER.debug(message.subject)
        emailSender.send(messageToSend)
    }
}
