package com.saculo.researcher.offer.infrastructure.adapters

import com.saculo.researcher.offer.domain.Offer
import com.saculo.researcher.offer.domain.ports.Crawler
import org.jsoup.nodes.Element

class PepperCrawler(private val connector: Connector) : Crawler {
    private val URL: String = "https://www.pepper.pl/grupa/telefony-i-smartfony"

    override fun extractOffers(): List<Offer> = getDocument()
            ?.map { offer -> extractOffer(offer) }
            ?: listOf()

    override fun extractOffer(offer: Element): Offer {
        val url = extractUrl(offer)
        val title = extractTitle(offer)
        val price = extractPrice(offer)
        val recentPrice = extractRecentPrice(offer)
        val discount = extractDiscountAmount(offer)

        return Offer(url, title, price, recentPrice, discount)
    }

    override fun extractUrl(offer: Element): String = offer.getElementsByClass("cept-dealBtn")
            .first()
            ?.attr("href") ?: "No url"

    override fun extractTitle(offer: Element): String = offer.getElementsByClass("thread-link")
            .first()
            ?.text() ?: "No title"


    override fun extractPrice(offer: Element): String = offer.getElementsByClass("thread-price")
            .first()
            ?.text() ?: "No price"

    override fun extractRecentPrice(offer: Element): String = offer.getElementsByClass("threadGrid-title")
            .first()
            .getElementsByClass("mute--text")
            .first()
            ?.text() ?: "No recent price"

    override fun extractDiscountAmount(offer: Element): String = offer.getElementsByClass("threadGrid-title")
            .first()
            .getElementsByClass("space--ml-1")
            .first()
            ?.text() ?: "No discount"

    private fun getDocument() = connector.connect(URL)?.getElementsByClass("thread--deal")

}
