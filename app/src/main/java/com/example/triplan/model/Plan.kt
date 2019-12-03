package com.example.triplan.model

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
