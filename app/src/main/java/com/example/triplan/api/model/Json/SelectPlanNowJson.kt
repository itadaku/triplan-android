package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class SelectPlanNowJson (
    @Json(name = "done")
    val done: Boolean
)