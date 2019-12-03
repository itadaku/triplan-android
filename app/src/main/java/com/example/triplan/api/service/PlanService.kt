package com.example.triplan.api.service

import com.example.triplan.api.model.Json.PlanInfoJson
import com.example.triplan.api.model.Json.TopPlanJson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlanService {
    @GET("/api/v1/plan/top")
    fun getTopPlans(): Call<List<TopPlanJson>>

    @GET("/api/v1/plan/info")
    fun getPlanInfo(@Query("id") id: Int): Call<PlanInfoJson>
}
