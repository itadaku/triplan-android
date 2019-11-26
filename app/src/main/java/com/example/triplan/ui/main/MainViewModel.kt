package com.example.triplan.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.repository.TestRepository
import com.example.triplan.model.Test

class MainViewModel: ViewModel() {
    private val testRepository: TestRepository = TestRepository()
    val test = MutableLiveData<Test>()

    fun getTest(): ApiResponse {
        var response: ApiResponse = ApiResponse.Failure(ApiResponse.ResponseType.Failure)
        testRepository.getTest({
            test.postValue(it.data)
            response = it
        }, {
            response = it
        })
        return response
    }
}
