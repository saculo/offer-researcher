package com.saculo.researcher.offer.infrastructure.configuration

import com.saculo.researcher.offer.domain.OfferFacade
import com.saculo.researcher.offer.domain.usecase.GetOffers
import com.saculo.researcher.offer.infrastructure.adapters.Connector
import com.saculo.researcher.offer.infrastructure.adapters.PepperCrawler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OffersConfiguration {
    @Bean
    fun offersFacade(): OfferFacade {
        return OfferFacade(GetOffers(listOf(PepperCrawler(Connector()))))
    }
}
