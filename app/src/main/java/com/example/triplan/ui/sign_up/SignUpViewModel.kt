package com.example.triplan.ui.sign_up

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.triplan.api.model.Body.SignUpBody
import com.example.triplan.api.repository.UserRepository
import com.example.triplan.model.Gender
import com.example.triplan.model.User

class SignUpViewModel(context: Context) : ViewModel() {
    val userRepository = UserRepository()
    fun sendSignUpData(
        name: String,
        email: String,
        password: String,
        lineId: Int,
        stationId: Int,
        age: Int,
        gender: Gender
    ) {
        val signUpBody = SignUpBody.setBody(name, email, password,lineId, stationId, age, gender)
        userRepository.signUp(signUpBody, {

        }, {

        })
    }
}