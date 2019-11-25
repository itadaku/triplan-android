package com.example.triplan.ui.sign_in

import androidx.lifecycle.ViewModel
import com.example.triplan.api.repository.UserRepository

class SignInViewModel : ViewModel() {
    val userRepository = UserRepository()
}