package com.example.triplan.api.service

import com.example.triplan.api.model.TestJson
import retrofit2.Call
import retrofit2.http.GET

interface TestService {
    @GET("/api/v1/test")
    fun getTest(): Call<TestJson>
}
