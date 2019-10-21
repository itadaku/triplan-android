package com.example.triplan.ui.welcome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, WelcomeActivity::class.java)
            context.startActivity(intent)
        }
    }
}
