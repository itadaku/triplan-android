package com.example.triplan.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.repository.PlanRepository
import com.example.triplan.api.repository.TestRepository
import com.example.triplan.api.repository.UserRepository
import com.example.triplan.data.PlanStore
import com.example.triplan.data.UserStore
import com.example.triplan.model.Plan
import com.example.triplan.model.TopPlan

class MainViewModel: ViewModel() {
    private val testRepository: TestRepository = TestRepository()
    private val userRepository = UserRepository()
    private val planRepository = PlanRepository()
    val userStore = UserStore
    val planStore = PlanStore


    fun getTopPlans(
        success: ((ApiResponse.Success<List<TopPlan>>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {

        when (planStore.topPlans.value) {
            null -> {
                planRepository.getTopPlans({
                    planStore.topPlans.value = it.data
                    success.invoke(it)
                }, {
                    failure.invoke(it)
                })
            }
            else -> {
                planStore.topPlans.value?.let {
                    success.invoke(ApiResponse.Success(it, ApiResponse.ResponseType.Success))
                }
            }
        }
    }
}
