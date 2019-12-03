package com.example.triplan.ui.content_plan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R

class ContentPlanActivity : AppCompatActivity() {
    private lateinit var viewModel: ContentPlanViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_plan)
        viewModel = ViewModelProviders.of(this).get(ContentPlanViewModel::class.java)
        val bundle = intent.extras
        bundle?.let {
            val planId = it.getInt(KEY_PLAN_ID)

        }
    }

    companion object {
        const val KEY_PLAN_ID = "plan_id"

        fun start(context: Context) {
            val intent = Intent(context, ContentPlanActivity::class.java)
            context.startActivity(intent)
        }

        fun start(context: Context, bundle: Bundle) {
            val intent = Intent(context, ContentPlanActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }

    }
}