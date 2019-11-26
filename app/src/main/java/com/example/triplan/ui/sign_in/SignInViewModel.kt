package com.example.triplan.ui.sign_in

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SignInBody
import com.example.triplan.api.repository.UserRepository
import com.example.triplan.model.User

class SignInViewModel : ViewModel() {
    private val userRepository = UserRepository()
    val user = MutableLiveData<User>()

    fun sendSignInData(signInBody: SignInBody) {
        var response : ApiResponse = ApiResponse.Failure(ApiResponse.ResponseType.Failure)

    }
}