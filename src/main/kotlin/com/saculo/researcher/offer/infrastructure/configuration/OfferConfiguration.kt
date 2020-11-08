package com.saculo.researcher.offer.infrastructure.configuration

import com.saculo.researcher.offer.domain.OfferFacade
import com.saculo.researcher.offer.domain.usecase.GetOffersHandler
import com.saculo.researcher.offer.infrastructure.OfferExtractor
import com.saculo.researcher.offer.infrastructure.adapters.crawler.Connector
import com.saculo.researcher.offer.infrastructure.adapters.crawler.PepperCrawler
import com.saculo.researcher.offer.infrastructure.adapters.persistence.KafkaNotificationPublisher
import com.saculo.researcher.offer.infrastructure.adapters.persistence.RedisOfferRepository
import com.saculo.researcher.offer.infrastructure.adapters.persistence.SpringRedisOfferRepository
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Source
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBinding(Source::class)
class OfferConfiguration {
    @Bean
    fun offerExtractor(redisOfferRepository: SpringRedisOfferRepository, source: Source): OfferExtractor {
        val offersHandler = GetOffersHandler(listOf(PepperCrawler(Connector())), RedisOfferRepository(redisOfferRepository))
        val publisher = KafkaNotificationPublisher(source)
        val offerFacade = OfferFacade(offersHandler, publisher)
        return OfferExtractor(offerFacade)
    }
}
