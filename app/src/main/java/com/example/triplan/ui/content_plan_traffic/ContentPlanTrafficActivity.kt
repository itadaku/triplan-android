package com.example.triplan.ui.content_plan_traffic

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import com.example.triplan.model.Traffic
import kotlinx.android.synthetic.main.activity_content_plan_traffic.*

class ContentPlanTrafficActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_plan_traffic)

        contentPlanTrafficBack.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
        val traffics = listOf<Traffic>()
        val contentPlanTrafficRecyclerViewAdapter = ContentPlanTrafficRecyclerViewAdapter(traffics)
        contentPlanTrafficRecyclerView.adapter = contentPlanTrafficRecyclerViewAdapter
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ContentPlanTrafficActivity::class.java)
            context.startActivity(intent)
        }
    }
}