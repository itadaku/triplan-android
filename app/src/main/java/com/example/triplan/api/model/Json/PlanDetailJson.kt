package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class PlanDetailJson(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "body")
    val body: String,
    @Json(name = "review")
    val review: Double,
    @Json(name = "link")
    val link: String,
    @Json(name = "image_paths")
    val imagePaths: List<ImagePathJson>,
    @Json(name = "user_reviews")
    val userReviews: List<UserReviewJson>,
    @Json(name = "address")
    val address: String
)