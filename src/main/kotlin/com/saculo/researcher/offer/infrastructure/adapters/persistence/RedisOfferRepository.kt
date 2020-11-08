package com.saculo.researcher.offer.infrastructure.adapters.persistence

import com.saculo.researcher.offer.domain.model.Offer
import com.saculo.researcher.offer.domain.ports.persistence.OfferRepository
import java.util.*

class RedisOfferRepository(private val offerRepository: SpringRedisOfferRepository) : OfferRepository {

    override fun add(offer: Offer): Offer = offerRepository.save(offer)

    override fun contains(id: UUID): Boolean = offerRepository.existsById(id)
}
