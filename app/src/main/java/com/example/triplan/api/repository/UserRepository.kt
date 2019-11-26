package com.example.triplan.api.repository

import android.util. Log
import com.example.triplan.api.ApiClient
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SignInBody
import com.example.triplan.api.model.Body.SignUpBody
import com.example.triplan.api.model.Json.UserJson
import com.example.triplan.api.service.UserService
import com.example.triplan.lib.JsonMapper
import com.example.triplan.lib.responseType
import com.example.triplan.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun signUp(
        signUpBody: SignUpBody,
        success: ((ApiResponse.Success<User>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<UserService>()
            .getService(UserService::class.java)
            .signUp(signUpBody)
            .enqueue(object : Callback<UserJson>{
                override fun onFailure(call: Call<UserJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<UserJson>, response: Response<UserJson>) {
                    when (response.responseType()) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toMapping(it), response.responseType()))
                            }
                        }

                        else -> {
                            Log.e("Error Code", response.code().toString())
                            failure.invoke(ApiResponse.Failure(response.responseType()))
                        }
                    }
                }
            })
    }

    fun singIn(
        signInBody: SignInBody,
        success: ((User) -> Unit),
        failure: (() -> Unit)
    ) {
        ApiClient<UserService>()
            .getService(UserService::class.java)
            .signIn(signInBody)
            .enqueue(object : Callback<UserJson>{
                override fun onFailure(call: Call<UserJson>, t: Throwable) {

                }

                override fun onResponse(call: Call<UserJson>, response: Response<UserJson>) {
                    response.body()?.let {
                        success.invoke(JsonMapper.toMapping(it))
                    }
                }
            })

    }
}