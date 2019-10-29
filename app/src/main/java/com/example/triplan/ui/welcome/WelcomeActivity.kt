package com.example.triplan.ui.welcome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import com.example.triplan.ui.signin.SigninActivity
import com.example.triplan.ui.signup.SignupActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        createAccountButton.setOnClickListener {
            //SignupActivity.start(this)
        }

        haveAccountText.setOnClickListener {
            SigninActivity.start(this)
        }
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, WelcomeActivity::class.java)
            context.startActivity(intent)
        }
    }
}
