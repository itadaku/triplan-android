package com.example.triplan.ui.content_plan_traffic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import kotlinx.android.synthetic.main.activity_content_plan_traffic.*

class ContentPlanTrafficActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_plan_traffic)
        val contentPlanTrafficDetailLists = resources.getStringArray(R.array.content_plan_traffic_detail_array_text)
            .toList()
        val contentPlanTrafficStationLists = resources.getStringArray(R.array.content_plan_traffic_station_array_text)
            .toList()
        val contentPlanTrafficRecyclerViewAdapter = ContentPlanTrafficRecyclerViewAdapter(contentPlanTrafficDetailLists, contentPlanTrafficStationLists)
        contentPlanTrafficRecyclerView.adapter = contentPlanTrafficRecyclerViewAdapter
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ContentPlanTrafficActivity::class.java)
            context.startActivity(intent)
        }
    }
}