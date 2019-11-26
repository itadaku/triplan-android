package com.example.triplan.api.repository

import android.net.DnsResolver
import android.util.Log
import com.example.triplan.api.ApiClient
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SettingContactBody
import com.example.triplan.api.model.Json.SettingContactJson
import com.example.triplan.api.service.SettingContactService
import com.example.triplan.lib.JsonMapper
import com.example.triplan.lib.responseType
import com.example.triplan.model.SettingContact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SettingRepository {
    fun sendContact(
        settingContactBody: SettingContactBody,
        success: ((ApiResponse.Success<SettingContact>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<SettingContactService>()
            .getService(SettingContactService::class.java)
            .sendContact(settingContactBody)
            .enqueue(object : Callback<SettingContactJson>{
                override fun onFailure(call: Call<SettingContactJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<SettingContactJson>, response: Response<SettingContactJson>) {
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