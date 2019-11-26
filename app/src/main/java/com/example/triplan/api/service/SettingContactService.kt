package com.example.triplan.api.service

import com.example.triplan.api.model.Body.SettingContactBody
import com.example.triplan.api.model.Json.SettingContactJson
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface SettingContactService {

    @Headers("Content-type: application/json")
    @POST("/api/v1/app/contact")
    fun sendContact(@Body settingContactBody: SettingContactBody): Call<SettingContactJson>
}