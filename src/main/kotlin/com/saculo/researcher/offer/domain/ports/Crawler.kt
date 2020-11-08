package com.saculo.researcher.offer.domain.ports

import com.saculo.researcher.offer.domain.Offer
import org.jsoup.nodes.Element

interface Crawler {
    fun extractOffers(): List<Offer>
    fun extractOffer(offer: Element) : Offer
    fun extractUrl(offer: Element): String
    fun extractTitle(offer: Element): String
    fun extractPrice(offer: Element): String
    fun extractRecentPrice(offer: Element): String
    fun extractDiscountAmount(offer: Element): String
}
