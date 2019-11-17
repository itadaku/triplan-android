package com.example.triplan.ui.content_plan_traffic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R

class ContentPlanTrafficActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_plan_traffic)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ContentPlanTrafficActivity::class.java)
            context.startActivity(intent)
        }
    }
}