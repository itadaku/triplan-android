package com.example.triplan.api.model.Body

import com.squareup.moshi.Json

class RequestBody (
    @Json(name = "text")
    val text: String
) {
    companion object {
        fun setBody(
            text: String
        ): RequestBody {
            return RequestBody(text)
        }
    }
}