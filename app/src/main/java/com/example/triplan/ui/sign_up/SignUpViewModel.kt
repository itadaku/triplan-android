package com.example.triplan.ui.sign_up

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SignUpBody
import com.example.triplan.api.repository.CommonRepository
import com.example.triplan.api.repository.UserRepository
import com.example.triplan.data.UserStore
import com.example.triplan.model.*

class SignUpViewModel : ViewModel() {
    private val userRepository = UserRepository()
    private val commonRepository = CommonRepository()
    val userStore = UserStore
    val line = MutableLiveData<Line>()
    val station = MutableLiveData<Stations>()

    fun sendSignUpData(
        signUpBody: SignUpBody,
        success: ((ApiResponse.Success<User>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit))  {
        userRepository.signUp(signUpBody, {
            userStore.user.postValue(it.data)
            success.invoke(it)
        }, {
            failure.invoke(it)
        })
    }

    fun getLines(
        success: ((ApiResponse.Success<Lines>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        commonRepository.getLines({
            success.invoke(it)
        }, {
            failure.invoke(it)
        })
    }

    fun getStations(
        line: Line,
        success: ((ApiResponse.Success<Stations>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        commonRepository.getStations(line, {
            success.invoke(it)
        }, {
            failure.invoke(it)
        })
    }
}