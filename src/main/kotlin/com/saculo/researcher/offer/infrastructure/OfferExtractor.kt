package com.saculo.researcher.offer.infrastructure

import com.saculo.researcher.offer.domain.model.Offer
import com.saculo.researcher.offer.domain.OfferFacade
import org.springframework.scheduling.annotation.Scheduled

class OfferExtractor(private val offerFacade: OfferFacade) {

    @Scheduled(fixedDelay = 1000000)
    fun run(): List<Offer> {
        return offerFacade.offers()
    }
}
