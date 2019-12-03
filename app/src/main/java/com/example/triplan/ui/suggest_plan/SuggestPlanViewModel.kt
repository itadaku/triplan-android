package com.example.triplan.ui.suggest_plan

import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.repository.PlanRepository
import com.example.triplan.data.PlanStore
import com.example.triplan.data.UserStore
import com.example.triplan.model.Plan

class SuggestPlanViewModel : ViewModel() {
    private val planRepository = PlanRepository()
    val planStore = PlanStore
    val userStore = UserStore

    fun getPlanProposeSecond(
        success: ((ApiResponse.Success<List<Plan>>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        planStore.suggestSecondBody.value?.let { suggestSecondBody ->
            userStore.token.value?.let { token ->
                planRepository.getPlanProposeSecond(token, suggestSecondBody, success, failure)
            }
        }
    }

}