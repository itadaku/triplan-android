package com.example.triplan.api.repository

import android.util.Log
import com.example.triplan.api.ApiClient
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Json.TestJson
import com.example.triplan.api.service.TestService
import com.example.triplan.lib.JsonMapper
import com.example.triplan.lib.responseType
import com.example.triplan.model.Test
import com.example.triplan.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TestRepository {
    fun getTest(
        success: ((ApiResponse.Success<Test>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<TestService>()
            .getService(TestService::class.java)
            .getTest()
            .enqueue(object : Callback<TestJson>{
                override fun onFailure(call: Call<TestJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<TestJson>, response: Response<TestJson>) {
                    when (response.responseType()) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toMapping(it), ApiResponse.ResponseType.Success))
                            }
                        }

                        else -> {
                            failure.invoke(ApiResponse.Failure(response.responseType()))
                        }
                    }
                }
            })
    }
}
