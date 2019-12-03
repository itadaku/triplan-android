package com.example.triplan.api.model.Body

import com.squareup.moshi.Json

class FeedBackBody (
    @Json(name = "text")
    val text: String
) {
    companion object {
        fun setBody(
            text: String
        ): FeedBackBody {
            return FeedBackBody(text)
        }
    }
}