package com.saculo.researcher.offer.infrastructure.adapters.crawler

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class Connector {
    fun connect(url: String): Document? {
        return Jsoup.connect(url).get()
    }
}

