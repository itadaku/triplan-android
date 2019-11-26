package com.example.triplan.api.model.Body

import com.squareup.moshi.Json

data class SettingBody (
    @Json(name = "text")
    val text: String
) {
    companion object {
        fun setBody(
            text: String
        ): SettingBody {
            return SettingBody(text)
        }
    }
}
