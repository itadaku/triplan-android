package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class StationsJson (
    @Json(name = "stations")
    val stations: List<StationJson>
)