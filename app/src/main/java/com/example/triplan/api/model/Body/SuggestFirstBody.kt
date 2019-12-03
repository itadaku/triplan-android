package com.example.triplan.api.model.Body

import com.squareup.moshi.Json

data class SuggestFirstBody(
    @Json(name = "agriculture")
    val agriculture: Boolean,
    @Json(name = "forestry")
    val forestry: Boolean,
    @Json(name = "fishing_industry")
    val fishingIndustry: Boolean,
    @Json(name = "budget")
    val budget: Int,
    @Json(name = "from_date")
    val fromDate: String,
    @Json(name = "to_date")
    val toDate: String
)