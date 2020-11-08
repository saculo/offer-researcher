package com.saculo.researcher.offer.infrastructure.model

data class MessageSent(
        val receiver: String,
        val subject: String,
        val body: String,
) : Event {
    override fun type(): String = "notification-offers"
}
