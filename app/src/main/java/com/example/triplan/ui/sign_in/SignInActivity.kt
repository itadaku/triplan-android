package com.example.triplan.ui.sign_in

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SignInActivity::class.java)
            context.startActivity(intent)
        }
    }
}
