package com.saculo.researcher.offer.domain.usecase

import com.saculo.researcher.offer.domain.model.Offer
import com.saculo.researcher.offer.domain.ports.Crawler
import com.saculo.researcher.offer.domain.ports.persistence.OfferRepository
import org.slf4j.LoggerFactory

class GetOffersHandler(private val crawlers: List<Crawler>, private val offerRepository: OfferRepository) {
    val LOGGER = LoggerFactory.getLogger(GetOffersHandler::class.java)

    fun handle(): List<Offer> = crawlers.asSequence().map { crawler -> crawler.extractOffers() }
            .flatten()
            .filter { !offerRepository.contains(it.id) }
            .map { offerRepository.add(it) }
            .onEach { LOGGER.debug(it.toString()) }.toList()
}
