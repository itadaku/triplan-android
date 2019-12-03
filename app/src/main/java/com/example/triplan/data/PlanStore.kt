package com.example.triplan.data

import androidx.lifecycle.MutableLiveData
import com.example.triplan.model.Schedule
import com.example.triplan.model.TopPlan

object PlanStore {
    val topPlans = MutableLiveData<List<TopPlan>>()
    val selectedPlan = MutableLiveData<Schedule>()
}