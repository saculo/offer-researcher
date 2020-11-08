package com.saculo.researcher.offer.domain.ports.persistence

import com.saculo.researcher.offer.domain.model.Offer
import java.util.*

interface OfferRepository {
    fun add(offer: Offer): Offer
    fun contains(id: UUID): Boolean
}
