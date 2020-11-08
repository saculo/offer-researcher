package com.saculo.researcher.offer.domain.usecase

import com.saculo.researcher.offer.domain.Offer
import com.saculo.researcher.offer.domain.ports.Crawler

class GetOffers(private val crawlers: List<Crawler>) {
    fun handle(): List<Offer> = crawlers.map { crawler -> crawler.extractOffers() }
            .flatten()
}
