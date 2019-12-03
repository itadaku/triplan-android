package com.example.triplan.api.repository

import android.util.Log
import com.example.triplan.api.ApiClient
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SuggestFirstBody
import com.example.triplan.api.model.Body.SuggestSecondBody
import com.example.triplan.api.model.Json.*
import com.example.triplan.api.service.PlanService
import com.example.triplan.lib.JsonMapper
import com.example.triplan.lib.responseType
import com.example.triplan.model.Plan
import com.example.triplan.model.PlanInfo
import com.example.triplan.model.SuggestArea
import com.example.triplan.model.TopPlan
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanRepository {
    fun getTopPlans(
        success: ((ApiResponse.Success<List<TopPlan>>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<PlanService>()
            .getService(PlanService::class.java)
            .getTopPlans()
            .enqueue(object : Callback<List<TopPlanJson>>{
                override fun onFailure(call: Call<List<TopPlanJson>>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<List<TopPlanJson>>, response: Response<List<TopPlanJson>>) {
                    when(response.responseType) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toMapping(it), response.responseType))
                            }
                        }
                        else -> {
                            failure.invoke(ApiResponse.Failure(response.responseType))
                        }
                    }
                }
            })
    }

    fun getPlanInfo(
        planId: Int,
        success: ((ApiResponse.Success<PlanInfo>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<PlanService>()
            .getService(PlanService::class.java)
            .getPlanInfo(planId)
            .enqueue(object : Callback<PlanInfoJson>{
                override fun onFailure(call: Call<PlanInfoJson>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<PlanInfoJson>, response: Response<PlanInfoJson>) {
                    when(response.responseType) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toMapping(it), response.responseType))
                            }
                        }
                        else -> {
                            failure.invoke(ApiResponse.Failure(response.responseType))
                        }
                    }
                }
            })
    }

    fun getPlanProposeFirst(
        token: String,
        suggestFirstBody: SuggestFirstBody,
        success: ((ApiResponse.Success<List<SuggestArea>>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<PlanService>()
            .getService(PlanService::class.java)
            .getPlanProposeFirst(
                token,
                suggestFirstBody.agriculture,
                suggestFirstBody.forestry,
                suggestFirstBody.fishingIndustry,
                suggestFirstBody.budget,
                suggestFirstBody.fromDate,
                suggestFirstBody.toDate )
            .enqueue(object : Callback<List<SuggestAreaJson>>{
                override fun onFailure(call: Call<List<SuggestAreaJson>>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<List<SuggestAreaJson>>, response: Response<List<SuggestAreaJson>>) {
                    when(response.responseType) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toSuggestPlanAreaMapping(it), response.responseType))
                            }
                        }
                        else -> {
                            failure.invoke(ApiResponse.Failure(response.responseType))
                        }
                    }
                }
            })
    }

    fun getPlanProposeSecond(
        token: String,
        suggestSecondBody: SuggestSecondBody,
        success: ((ApiResponse.Success<List<Plan>>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        ApiClient<PlanService>()
            .getService(PlanService::class.java)
            .getPlanProposeSecond(
                token,
                suggestSecondBody.prefectureId,
                suggestSecondBody.planTags,
                suggestSecondBody.fromDate,
                suggestSecondBody.toDate )
            .enqueue(object : Callback<List<PlanJson>>{
                override fun onFailure(call: Call<List<PlanJson>>, t: Throwable) {
                    Log.e("Network Failure", t.message.toString())
                    failure.invoke(ApiResponse.Failure(ApiResponse.ResponseType.Failure))
                }

                override fun onResponse(call: Call<List<PlanJson>>, response: Response<List<PlanJson>>) {
                    when(response.responseType) {
                        ApiResponse.ResponseType.Success -> {
                            response.body()?.let {
                                success.invoke(ApiResponse.Success(JsonMapper.toPlanListMapping(it), response.responseType))
                            }
                        }
                        else -> {
                            failure.invoke(ApiResponse.Failure(response.responseType))
                        }
                    }
                }
            })
    }
}
