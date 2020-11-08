package com.saculo.researcher.offer.domain

import com.saculo.researcher.offer.domain.usecase.GetOffers

class OfferFacade(val handler: GetOffers) {
    fun offers() = handler.handle()
}
