package com.saculo.researcher.offer.domain

import com.saculo.researcher.offer.domain.model.Offer
import com.saculo.researcher.offer.domain.usecase.GetOffersHandler
import com.saculo.researcher.offer.infrastructure.adapters.persistence.KafkaNotificationPublisher
import com.saculo.researcher.offer.infrastructure.model.MessageSent

class OfferFacade(private val handler: GetOffersHandler, private val publisher: KafkaNotificationPublisher) {
    fun offers(): List<Offer> {
        val offers = handler.handle()
        publisher.publish(
                MessageSent(
                        "lavoholicc@gmail.com",
                        "Nowe oferty!",
                        offers.joinToString(separator = "\n") { it.toString() }
                )
        )
        return offers
    }
}
