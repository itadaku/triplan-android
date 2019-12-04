package com.example.triplan.ui.content_plan_traffic

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.model.Traffic
import kotlinx.android.synthetic.main.activity_content_plan_traffic.*

class ContentPlanTrafficActivity : AppCompatActivity() {
    lateinit var viewModel: ContentPlanTrafficViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_plan_traffic)
        viewModel = ViewModelProviders.of(this).get(ContentPlanTrafficViewModel::class.java)
        contentPlanTrafficBack.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
        viewModel.planStore.selectedSchedule.value?.let {
            val traffics = listOf(Traffic(it.title, it.body))
            val contentPlanTrafficRecyclerViewAdapter = ContentPlanTrafficRecyclerViewAdapter(traffics)
            contentPlanTrafficRecyclerView.adapter = contentPlanTrafficRecyclerViewAdapter
        }

    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ContentPlanTrafficActivity::class.java)
            context.startActivity(intent)
        }
    }
}