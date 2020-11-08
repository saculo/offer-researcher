package com.saculo.researcher.offer.domain.ports.persistence;

import com.saculo.researcher.offer.infrastructure.model.Event

interface EventPublisher {
    fun publish(event: Event)
}
