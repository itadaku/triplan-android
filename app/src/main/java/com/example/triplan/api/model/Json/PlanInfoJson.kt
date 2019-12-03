package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class PlanInfoJson(
    @Json(name = "plan")
    val plan: PlanJson,
    @Json(name = "schedules")
    val schedules: List<ScheduleJson>
)