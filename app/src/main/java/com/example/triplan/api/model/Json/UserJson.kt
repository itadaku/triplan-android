package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class UserJson(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "age")
    val age: Int,
    @Json(name = "lineStationId")
    val lineStationId: Int,
    @Json(name = "gender")
    val gender: Int,
    @Json(name = "token")
    val token: String
)