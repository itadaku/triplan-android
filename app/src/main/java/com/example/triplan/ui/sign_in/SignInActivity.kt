package com.example.triplan.ui.sign_in

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import com.example.triplan.ui.content_plan_detail.ContentPlanDetailActivity
import com.example.triplan.ui.content_plan_traffic.ContentPlanTrafficActivity
import com.example.triplan.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.item_content_plan_traffic.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        signInButton.setOnClickListener {
            
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SignInActivity::class.java)
            context.startActivity(intent)
        }
    }
}
