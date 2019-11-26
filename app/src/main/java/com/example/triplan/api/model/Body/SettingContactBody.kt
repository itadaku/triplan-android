package com.example.triplan.api.model.Body

import com.squareup.moshi.Json

data class SettingContactBody(
    @Json(name = "userId")
    val userId: Int,
    @Json(name = "content")
    val content: String
) {
    companion object {
        fun setBody(
            userId: Int,
            content: String
        ): SettingContactBody {
            return SettingContactBody(userId, content)
        }
    }
}