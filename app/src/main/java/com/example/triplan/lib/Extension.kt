package com.example.triplan.lib

import com.example.triplan.api.ApiResponse
import retrofit2.Response

fun <T> Response<T>.responseType() = when (this.code()) {
    in 200..299 -> ApiResponse.ResponseType.Success
    in 400..499 -> ApiResponse.ResponseType.ClientError
    in 500..599 -> ApiResponse.ResponseType.ServerError
    else -> ApiResponse.ResponseType.Failure
}