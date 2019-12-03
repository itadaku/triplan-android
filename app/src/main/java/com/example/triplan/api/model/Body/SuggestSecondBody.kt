package com.example.triplan.api.model.Body

import com.squareup.moshi.Json

data class SuggestSecondBody(
    @Json(name = "prefecture_id")
    val prefectureId: Int,
    @Json(name = "plan_tags")
    val planTags: List<Int>,
    @Json(name = "from_date")
    val fromDate: String,
    @Json(name = "to_date")
    val toDate: String
)