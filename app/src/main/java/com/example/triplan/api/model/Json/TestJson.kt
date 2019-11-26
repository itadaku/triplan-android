package com.example.triplan.api.model.Json

import com.example.triplan.model.Test
import com.squareup.moshi.Json

data class TestJson (
    @Json(name = "message")
    val message: String,
    @Json(name = "triplan_message")
    val triplanMessage: String
)
