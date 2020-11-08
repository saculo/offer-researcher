package com.saculo.researcher.offer.infrastructure.adapters.persistence

import com.saculo.researcher.offer.domain.model.Offer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SpringRedisOfferRepository : CrudRepository<Offer, UUID>
