package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class PlanJson(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "review")
    val review: Double,
    @Json(name = "days_nights")
    val daysNights: Int,
    @Json(name = "min_budget")
    val minBudget: Int,
    @Json(name = "max_budget")
    val maxBudget: Int,
    @Json(name = "number_of_people")
    val numberOfPeople: Int,
    @Json(name = "address")
    val address: String = "",
    @Json(name = "purpose")
    val purpose: List<String>
)
