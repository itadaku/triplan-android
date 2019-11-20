package com.example.triplan.ui.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.triplan.api.repository.TestRepository
import com.example.triplan.model.Test

class MainViewModel: ViewModel() {
    private val testRepository: TestRepository
    init {
        testRepository = TestRepository()
    }

    var name: String = ""

    fun getTest() {
        testRepository.getTest({

        }, {

        })
    }
}