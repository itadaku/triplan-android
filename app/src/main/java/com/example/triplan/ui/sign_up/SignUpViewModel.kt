package com.example.triplan.ui.sign_up

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SignUpBody
import com.example.triplan.api.repository.UserRepository
import com.example.triplan.data.UserStore
import com.example.triplan.model.Gender
import com.example.triplan.model.User

class SignUpViewModel : ViewModel() {
    private val userRepository = UserRepository()
    val userStore = UserStore

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
}