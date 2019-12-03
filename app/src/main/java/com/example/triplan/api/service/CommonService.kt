package com.example.triplan.api.service

import com.example.triplan.api.model.Body.FeedBackBody
import com.example.triplan.api.model.Body.RequestBody
import com.example.triplan.api.model.Json.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Body
import retrofit2.http.Query

interface CommonService {
    @GET("/api/v1/lines")
    fun getLInes(): Call<LinesJson>

    @GET("/api/v1/line/{lineId}/stations")
    fun getStations(@Path("lineId") lineId: Int): Call<StationsJson>

    @Headers("Content-type: application/json")
    @POST("/api/v1/app/contact")
    fun sendRequestData(@Query("token") token: String, @Body settingBody: RequestBody): Call<RequestJson>

    @Headers("Content-type: application/json")
    @POST("/api/v1/app/feedback")
    fun sendFeedBackData(@Query("token") token: String, @Body settingBody: FeedBackBody): Call<FeedBackJson>
}