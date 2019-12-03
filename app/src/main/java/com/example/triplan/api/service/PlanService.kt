package com.example.triplan.api.service

import com.example.triplan.api.model.Json.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface PlanService {
    @GET("/api/v1/plan/top")
    fun getTopPlans(): Call<List<TopPlanJson>>

    @GET("/api/v1/plan/info")
    fun getPlanInfo(@Query("id") id: Int): Call<PlanInfoJson>

    @GET("/api/v1/propose/first")
    fun getPlanProposeFirst(
        @Query("token") token: String,
        @Query("agriculture") agriculture: Boolean,
        @Query("forestry") forestry: Boolean,
        @Query("fishing_industry") fishingIndustry: Boolean,
        @Query("budget") budget: Int,
        @Query("from_date") fromDate: String,
        @Query("to_date") toDate: String
    ): Call<List<SuggestAreaJson>>

    @GET("/api/v1/propose/second")
    fun getPlanProposeSecond(
        @Query("token") token: String,
        @Query("prefecture_id") prefectureId: Int,
        @Query("plan_tags") planTags: List<Int>,
        @Query("from_date") fromDate: String,
        @Query("to_date") toDate: String
    ): Call<List<PlanJson>>
}
