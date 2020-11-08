package com.saculo.researcher.offer.domain

data class Offer(
        val url: String,
        val title: String,
        val price: String,
        val recentPrice: String = "0.0",
        val discountAmount: String = "0.0"
)
