package com.example.triplan.api.model.Json

import com.squareup.moshi.Json

data class SettingContactJson (
    @Json(name = "userId")
    val userId: Int,
    @Json(name = "content")
    val content: String
)