package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class TopPlanJson(
    @Json(name = "top_title")
    val title: String,
    @Json(name = "plans")
    val plans: List<PlanJson>
)
