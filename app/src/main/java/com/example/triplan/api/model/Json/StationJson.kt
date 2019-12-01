package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class StationJson(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)
