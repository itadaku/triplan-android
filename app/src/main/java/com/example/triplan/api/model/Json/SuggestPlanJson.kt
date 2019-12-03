package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class SuggestPlanJson(
    @Json(name = "propose_plans")
    val proposePlans: List<PlanJson>
)