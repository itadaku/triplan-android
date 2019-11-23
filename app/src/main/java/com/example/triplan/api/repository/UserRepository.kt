package com.example.triplan.api.repository

import com.example.triplan.api.ApiClient
import com.example.triplan.api.model.Body.SignUpBody
import com.example.triplan.api.model.Json.UserJson
import com.example.triplan.api.service.UserService
import com.example.triplan.lib.JsonMapper
import com.example.triplan.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun signUp(
        signUpBody: SignUpBody,
        success: ((User) -> Unit),
        failure: (() -> Unit)
    ) {
        ApiClient<UserService>()
            .getService(UserService::class.java)
            .signUp(signUpBody)
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