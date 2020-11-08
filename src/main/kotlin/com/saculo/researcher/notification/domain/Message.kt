package com.saculo.researcher.notification.domain

data class Message (
        val receiver: String,
        val subject: String,
        val body: String
)
