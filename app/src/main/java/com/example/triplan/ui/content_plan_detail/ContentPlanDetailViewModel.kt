package com.example.triplan.ui.content_plan_detail

import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.repository.PlanRepository
import com.example.triplan.data.PlanStore
import com.example.triplan.model.PlanDetail

class ContentPlanDetailViewModel : ViewModel() {
    val planStore = PlanStore
    private val planRepository = PlanRepository()

    fun getPlanDetail(
        scheduleId: Int,
        success: ((ApiResponse.Success<PlanDetail>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        planRepository.getPlanDetail(scheduleId, success, failure)
    }
}