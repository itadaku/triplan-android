package com.example.triplan.ui.sign_in

import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SignInBody
import com.example.triplan.api.repository.UserRepository
import com.example.triplan.data.UserStore
import com.example.triplan.model.User

class SignInViewModel : ViewModel() {
    private val userRepository = UserRepository()
    val userStore = UserStore

    fun sendSignInData(
        signInBody: SignInBody,
        success: ((ApiResponse.Success<User>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ) {
        userRepository.singIn(signInBody, {
            userStore.user.postValue(it.data)
            success.invoke(it)
        }, {
            failure.invoke(it)
        })
    }
}