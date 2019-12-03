package com.example.triplan.api.repository

import android.util.Log
import com.example.triplan.api.ApiClient
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.FeedBackBody
import com.example.triplan.api.model.Body.RequestBody
import com.example.triplan.api.model.Json.*
import com.example.triplan.api.service.CommonService
import com.example.triplan.lib.JsonMapper
import com.example.triplan.lib.responseType
import com.example.triplan.model.Line
import com.example.triplan.model.Lines
import com.example.triplan.model.Setting
import com.example.triplan.model.Stations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommonRepository {
    fun getLines(
        success: ((ApiResponse.Success<Lines>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<CommonService>()
            .getService(CommonService::class.java)
            .getLInes()
            .enqueue(object : Callback<LinesJson>{
                override fun onFailure(call: Call<LinesJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<LinesJson>, response: Response<LinesJson>) {
                    when (response.responseType) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toMapping(it), response.responseType))
                            }
                        }

                        else -> {
                            Log.e("Error Code", response.code().toString())
                            failure.invoke(ApiResponse.Failure(response.responseType))
                        }
                    }
                }
            })
    }

    fun getStations(
        line: Line,
        success: ((ApiResponse.Success<Stations>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<CommonService>()
            .getService(CommonService::class.java)
            .getStations(line.id)
            .enqueue(object : Callback<StationsJson> {
                override fun onFailure(call: Call<StationsJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<StationsJson>, response: Response<StationsJson>
                ) {
                    when (response.responseType) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toMapping(it), response.responseType))
                            }
                        }

                        else -> {
                            Log.e("Error Code", response.code().toString())
                            failure.invoke(ApiResponse.Failure(response.responseType))
                        }
                    }
                }
        })
    }

    fun sendRequestData(
        requestBody: RequestBody,
        success: ((ApiResponse.Success<Setting>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<CommonService>()
            .getService(CommonService::class.java)
            .sendContactData(requestBody)
            .enqueue(object : Callback<RequestJson>{
                override fun onFailure(call: Call<RequestJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<RequestJson>, response: Response<RequestJson>) {
                    when (response.responseType) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toMapping(it), response.responseType))
                            }
                        }

                        else -> {
                            Log.d("Error Code", response.code().toString())
                            failure.invoke(ApiResponse.Failure(response.responseType))
                        }
                    }
                }
            })
    }

    fun sendFeedbackData(
        feedBackBody: FeedBackBody,
        success: ((ApiResponse.Success<Setting>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<CommonService>()
            .getService(CommonService::class.java)
            .sendFeedbackData(feedBackBody)
            .enqueue(object : Callback<FeedBackJson>{
                override fun onFailure(call: Call<FeedBackJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<FeedBackJson>, response: Response<FeedBackJson>) {
                    when (response.responseType) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toMapping(it), response.responseType))
                            }
                        }

                        else -> {
                            Log.d("Error Code", response.code().toString())
                            failure.invoke(ApiResponse.Failure(response.responseType))
                        }
                    }
                }
            })
    }
}