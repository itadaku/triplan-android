package com.example.triplan.model

data class SuggestArea(
    val id: Int,
    val name: String,
    val matchScore: Double,
    val population: String,
    val congestionRate: Double
)