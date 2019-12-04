package com.example.triplan.ui.content_plan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Json.SelectPlanNowJson
import com.example.triplan.api.repository.PlanRepository
import com.example.triplan.data.PlanStore
import com.example.triplan.data.UserStore
import com.example.triplan.model.PlanInfo

class ContentPlanViewModel: ViewModel() {
    private val planRepository = PlanRepository()
    val planInfo = MutableLiveData<PlanInfo>()
    val planStore = PlanStore
    val userStore = UserStore

    fun getPlanInfo(
        planId: Int,
        success: ((ApiResponse.Success<PlanInfo>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        planRepository.getPlanInfo(planId, {
            success.invoke(it)
        }, {
            failure.invoke(it)
        })
    }

    fun selectPlanNow(
        planId: Int,
        success: ((ApiResponse.Success<SelectPlanNowJson>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        userStore.token.value?.let { token ->
            planRepository.selectPlanNow(token, planId, success, failure)
        }
    }
}