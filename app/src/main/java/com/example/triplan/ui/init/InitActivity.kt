package com.example.triplan.ui.init

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.data.UserStore
import com.example.triplan.ui.main.MainActivity
import com.example.triplan.ui.welcome.WelcomeActivity

class InitActivity : AppCompatActivity() {
    lateinit var viewModel: InitViewModel
    private val userStore = UserStore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        viewModel = ViewModelProviders.of(this).get(InitViewModel::class.java)
        viewModel.userStore.setToken(applicationContext)
        val token = viewModel.userStore.token.value
        if (token.isNullOrEmpty()) {
            WelcomeActivity.start(this)
        } else {
            MainActivity.start(this)
        }
    }
}
