package com.example.triplan.lib

import com.example.triplan.api.ApiResponse
import retrofit2.Response

val Response<*>.responseType: ApiResponse.ResponseType
    get() = when (this.code()) {
        in 200..299 -> ApiResponse.ResponseType.Success
        in 400..499 -> ApiResponse.ResponseType.ClientError
        in 500..599 -> ApiResponse.ResponseType.ServerError
        else -> ApiResponse.ResponseType.Failure
    }

fun String.isMatch(pattern: String) = Regex(pattern).containsMatchIn(this)

fun<T> List<T>.getSafety(index: Int): T? {
    if (index >= this.size) return null

    return this[index]
}