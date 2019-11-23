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
    @Json(name = "nearest_station")
    val nearestStation: String,
    @Json(name = "gender")
    val gender: Int,
    @Json(name = "token")
    val token: String
)