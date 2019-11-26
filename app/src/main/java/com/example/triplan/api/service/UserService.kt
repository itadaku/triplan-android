package com.example.triplan.api.service

import com.example.triplan.api.model.Body.SignInBody
import com.example.triplan.api.model.Body.SignUpBody
import com.example.triplan.api.model.Json.UserJson
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST



interface UserService {

    @Headers("Content-type: application/json")
    @POST("/api/v1/user/register")
    fun signUp(@Body signUpBody: SignUpBody): Call<UserJson>

    @Headers("Content-type: application/json")
    @POST("/api/v1/user/login")
    fun signIn(@Body signInBody: SignInBody): Call<UserJson>
}