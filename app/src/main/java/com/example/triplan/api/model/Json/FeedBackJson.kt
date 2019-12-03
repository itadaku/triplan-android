package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class FeedBackJson (
    @Json(name = "done")
    val done: Boolean
)