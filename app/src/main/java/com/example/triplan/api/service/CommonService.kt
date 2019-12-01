package com.example.triplan.api.service

import com.example.triplan.api.model.Json.LinesJson
import com.example.triplan.api.model.Json.StationsJson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CommonService {
    @GET("/api/v1/lines")
    fun getLInes(): Call<LinesJson>

    @GET("/api/v1/line/{lineId}/stations")
    fun getStations(@Path("lineId") lineId: Int): Call<StationsJson>
}