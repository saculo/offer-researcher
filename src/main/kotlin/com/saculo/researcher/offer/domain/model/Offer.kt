package com.saculo.researcher.offer.domain.model

import org.springframework.data.redis.core.RedisHash
import java.util.*

@RedisHash("offer")
data class Offer(
        val url: String,
        val title: String,
        val price: String,
        val recentPrice: String = "0.0",
        val discountAmount: String = "0.0",
        val id: UUID = UUID.nameUUIDFromBytes(url.toByteArray())
) {
    override fun toString(): String {
        return "Title: $title price: $price URL: $url recentPrice: $recentPrice discount: $discountAmount"
    }
}
