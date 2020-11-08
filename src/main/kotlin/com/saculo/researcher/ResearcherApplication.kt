package com.saculo.researcher

import com.saculo.researcher.offer.infrastructure.configuration.OffersConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ResearcherApplication: CommandLineRunner {
    @Autowired
    lateinit var offersConfiguration: OffersConfiguration

    override fun run(vararg args: String?) {
        val offersFacade = offersConfiguration.offersFacade()
        offersFacade.offers().forEach { println(it) }
    }
}

fun main(args: Array<String>) {
    runApplication<ResearcherApplication>(*args)
}
