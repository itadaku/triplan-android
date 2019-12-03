package com.example.triplan.model

import com.squareup.moshi.Json

data class Plan(
    val id: Int,
    val title: String,
    val image: String,
    val review: Double,
    val daysNights: Int,
    val minBudget: Int,
    val maxBudget: Int,
    val numberOfPeople: Int,
    val purpose: List<String>
)