package com.example.triplan.api.repository

import android.util.Log
import com.example.triplan.api.ApiClient
import com.example.triplan.api.model.Json.TestJson
import com.example.triplan.api.service.TestService
import com.example.triplan.lib.JsonMapper
import com.example.triplan.model.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TestRepository {
    fun getTest(
        success: ((Test) -> Unit),
        failure: (() -> Unit)
    ) {
        ApiClient<TestService>()
            .getService(TestService::class.java)
            .getTest()
            .enqueue(object : Callback<TestJson>{
                override fun onFailure(call: Call<TestJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke()
                }

                override fun onResponse(call: Call<TestJson>, response: Response<TestJson>) {
                    response.body()?.let {
                        success.invoke(JsonMapper.toMapping(it))
                    }
                }
            })
    }
}
