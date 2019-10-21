package com.example.triplan.ui.init

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.triplan.R
import com.example.triplan.ui.main.MainActivity

class InitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        MainActivity.start(this)
    }
}