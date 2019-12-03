package com.example.triplan.ui.suggest_area

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.repository.PlanRepository
import com.example.triplan.data.PlanStore
import com.example.triplan.data.UserStore
import com.example.triplan.model.SuggestArea

class SuggestAreaViewModel : ViewModel() {
    private val planRepository = PlanRepository()
    val userStore = UserStore
    val planStore = PlanStore

    fun getPlanProposeFirst(
        success: ((ApiResponse.Success<List<SuggestArea>>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        planStore.suggestFirstBody.value?.let { suggestFirstBody ->
            userStore.token.value?.let { token ->
                planRepository.getPlanProposeFirst(token, suggestFirstBody, {
                    success.invoke(it)
                }, {
                    failure.invoke(it)  
                })
            }
        }
    }

}