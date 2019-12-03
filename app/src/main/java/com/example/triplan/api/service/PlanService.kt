package com.example.triplan.api.service

import com.example.triplan.api.model.Json.TopPlanJson
import retrofit2.Call
import retrofit2.http.GET

interface PlanService {
    @GET("/api/v1/plan/top")
    fun getTopPlans(): Call<List<TopPlanJson>>
}