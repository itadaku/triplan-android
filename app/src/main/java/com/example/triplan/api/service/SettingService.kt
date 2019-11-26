package com.example.triplan.api.service

import com.example.triplan.api.model.Body.SettingBody
import com.example.triplan.api.model.Json.SettingJson
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SettingService {

    @Headers("Content-type: application/json")
    @POST("/api/v1/app/contact")
    fun sendContactData(@Body settingBody: SettingBody): Call<SettingJson>

    @Headers("Content-type: application/json")
    @POST("/api/v1/app/feedback")
    fun sendFeedbackData(@Body settingBody: SettingBody): Call<SettingJson>
}
