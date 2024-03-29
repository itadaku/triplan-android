package com.example.triplan.data

import androidx.lifecycle.MutableLiveData
import com.example.triplan.api.model.Body.SuggestFirstBody
import com.example.triplan.api.model.Body.SuggestSecondBody
import com.example.triplan.model.PlanInfo
import com.example.triplan.model.Schedule
import com.example.triplan.model.TopPlan

object PlanStore {
    val topPlans = MutableLiveData<List<TopPlan>>()
    val nowPlans = MutableLiveData<PlanInfo>()
    val selectedSchedule = MutableLiveData<Schedule>()
    val suggestFirstBody = MutableLiveData<SuggestFirstBody>()
    val suggestSecondBody = MutableLiveData<SuggestSecondBody>()
}