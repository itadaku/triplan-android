package com.example.triplan.model

data class User(
    val id: Long,
    val name: String,
    val email: String,
    val age: Int,
    val gender: Gender,
    val lineStationId: Int,
    var token: String
)