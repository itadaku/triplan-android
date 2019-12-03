package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class SuggestAreaJson(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json( name = "match_score")
    val matchScore: Double,
    @Json( name = "population")
    val population: String,
    @Json(name = "congestion_rate")
    val congestionRate: Double
)