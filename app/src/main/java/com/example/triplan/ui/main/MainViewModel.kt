package com.example.triplan.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.repository.TestRepository
import com.example.triplan.data.UserStore
import com.example.triplan.model.Test

class MainViewModel: ViewModel() {
    private val testRepository: TestRepository = TestRepository()
    val userStore = UserStore
    val test = MutableLiveData<Test>()

    fun getTest(
        success: ((ApiResponse.Success<Test>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        testRepository.getTest({
            success.invoke(it)
        }, {
            failure.invoke(it)
        })
    }
}
