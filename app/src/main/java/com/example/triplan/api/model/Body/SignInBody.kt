package com.example.triplan.api.model.Body

import com.squareup.moshi.Json

data class SignInBody(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String
)