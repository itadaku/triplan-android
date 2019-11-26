package com.example.triplan.ui.sign_up

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SignUpBody
import com.example.triplan.api.repository.UserRepository
import com.example.triplan.model.Gender
import com.example.triplan.model.User

class SignUpViewModel : ViewModel() {
    private val userRepository = UserRepository()
    val user = MutableLiveData<User>()

    fun sendSignUpData(signUpBody: SignUpBody): ApiResponse {
        var response: ApiResponse = ApiResponse.Failure(ApiResponse.ResponseType.Failure)
        userRepository.signUp(signUpBody, {
            user.postValue(it.data)
            response = it
        }, {
            response = it
        })
        return response
    }
}