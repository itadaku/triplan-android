package com.example.triplan.api.service

import com.example.triplan.api.model.Body.FeedBackBody
import com.example.triplan.api.model.Body.RequestBody
import com.example.triplan.api.model.Json.*
import retrofit2.Call
import retrofit2.http.*

interface CommonService {
    @GET("/api/v1/lines")
    fun getLInes(): Call<LinesJson>

    @GET("/api/v1/line/{lineId}/stations")
    fun getStations(@Path("lineId") lineId: Int): Call<StationsJson>

    @Headers("Content-type: application/json")
    @POST("/api/v1/app/contact")
    fun sendContactData(@Body settingBody: RequestBody): Call<RequestJson>

    @Headers("Content-type: application/json")
    @POST("/api/v1/app/feedback")
    fun sendFeedbackData(@Body settingBody: FeedBackBody): Call<FeedBackJson>
}