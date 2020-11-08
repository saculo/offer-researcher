package com.saculo.researcher.offer.infrastructure.adapters.persistence

import com.saculo.researcher.offer.domain.ports.persistence.EventPublisher
import com.saculo.researcher.offer.infrastructure.model.Event
import org.springframework.cloud.stream.messaging.Source
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.GenericMessage

class KafkaNotificationPublisher(private val source: Source): EventPublisher {

    override fun publish(event: Event) {
        val headers: Map<String, Any> = hashMapOf(Pair("type", event.type()))
        source.output().send(GenericMessage(event, MessageHeaders(headers)))
    }
}
