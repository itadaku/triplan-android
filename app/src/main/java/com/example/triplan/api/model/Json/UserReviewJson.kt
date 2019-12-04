package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class UserReviewJson(
    @Json(name = "sentence")
    val sentence: String,
    @Json(name = "icon")
    val icon: String,
    @Json(name = "body")
    val body: String,
    @Json(name = "evaluation")
    val evaluation: Int
)