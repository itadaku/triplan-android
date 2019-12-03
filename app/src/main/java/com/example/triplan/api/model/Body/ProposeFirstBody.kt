package com.example.triplan.api.model.Body

import com.squareup.moshi.Json

data class ProposeFirstBody(
    @Json(name = "agriculture")
    val agriculture: Boolean,
    @Json(name = "forestry")
    val forestry: Boolean,
    @Json(name = "fishing_industry")
    val fishingIndustry: Boolean,
    @Json(name = "from_date")
    val fromDate: String,
    @Json(name = "to_date")
    val to_date: String
)