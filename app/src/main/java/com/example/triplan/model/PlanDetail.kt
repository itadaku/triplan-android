package com.example.triplan.model

data class PlanDetail(
    val id: Int,
    val title: String,
    val body: String,
    val review: Double,
    val link: String,
    val imagePaths: List<ImagePath>,
    val userReviews: List<UserReview>,
    val address: String
)