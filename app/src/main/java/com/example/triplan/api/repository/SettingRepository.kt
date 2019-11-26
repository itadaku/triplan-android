package com.example.triplan.api.repository

import android.net.DnsResolver
import android.util.Log
import com.example.triplan.api.ApiClient
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SettingBody
import com.example.triplan.api.model.Json.SettingJson
import com.example.triplan.api.service.SettingService
import com.example.triplan.lib.JsonMapper
import com.example.triplan.lib.responseType
import com.example.triplan.model.Setting
import com.example.triplan.ui.setting_feedback.SettingFeedbackActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SettingRepository {
    fun sendContactData(
        settingBody: SettingBody,
        success: ((ApiResponse.Success<Setting>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<SettingService>()
            .getService(SettingService::class.java)
            .sendContactData(settingBody)
            .enqueue(object : Callback<SettingJson>{
                override fun onFailure(call: Call<SettingJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<SettingJson>, response: Response<SettingJson>) {
                    when (response.responseType()) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toMapping(it), response.responseType()))
                            }
                        }

                        else -> {
                            Log.d("Error Code", response.code().toString())
                            failure.invoke(ApiResponse.Failure(response.responseType()))
                        }
                    }
                }
            })
    }

    fun sendFeedbackData(
        settingBody: SettingBody,
        success: ((ApiResponse.Success<Setting>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<SettingService>()
            .getService(SettingService::class.java)
            .sendFeedbackData(settingBody)
            .enqueue(object : Callback<SettingJson>{
                override fun onFailure(call: Call<SettingJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<SettingJson>, response: Response<SettingJson>) {
                    when (response.responseType()) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toMapping(it), response.responseType()))
                            }
                        }

                        else -> {
                            Log.d("Error Code", response.code().toString())
                            failure.invoke(ApiResponse.Failure(response.responseType()))
                        }
                    }
                }
            })
    }
}