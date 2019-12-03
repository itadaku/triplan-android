package com.example.triplan.api.model.Body

import com.squareup.moshi.Json

data class FeedBackBody (
    @Json(name = "text")
    val text: String
)