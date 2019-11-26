package com.example.triplan.api

import android.content.Context
import com.example.triplan.R

open class ApiResponse {
    data class Success<out T>(val data: T, val responseType: ResponseType) : ApiResponse()
    data class Failure(val responseType: ResponseType) : ApiResponse() {
        fun errorMessage(context: Context) = when (this.responseType) {
            ResponseType.ClientError -> context.getString(R.string.network_client_error_message)
            ResponseType.ServerError -> context.getString(R.string.network_server_error_message)
            else -> context.getString(R.string.network_failure_error)
        }
    }

    enum class ResponseType {
        Success,
        ClientError,
        ServerError,
        Failure
    }
}
