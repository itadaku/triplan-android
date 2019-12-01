package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class LinesJson(
    @Json(name = "lines")
    val lines: List<LineJson>
)