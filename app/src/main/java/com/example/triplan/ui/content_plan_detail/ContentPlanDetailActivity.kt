package com.example.triplan.ui.content_plan_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import kotlinx.android.synthetic.main.activity_content_plan_detail.*

class ContentPlanDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_plan_detail)
        val reviews = resources.getStringArray(R.array.review_comments)
            .toList()
        val reviewListRecyclerViewAdapter = ReviewListRecyclerViewAdapter(reviews)
        contentPlanDetailReviewRecyclerView.adapter = reviewListRecyclerViewAdapter

        val reviewGraphNumbers = resources.getStringArray(R.array.review_graph_numbers)
            .toList()
        val reviewGraphBarValues = resources.getStringArray(R.array.review_graph_bar_values)
            .toList()
//        val reviewGraphBarWidths = resources.getStringArray(R.array.review_graph_bar_widths)
//            .toList()
        val reviewGraphBarWidths = arrayListOf<Float>(5f,4f,3f,2f,1f)
//        val reviewGraphBarWidths = arrayListOf<Int>(100,90,80,70,60)
        val reviewGraphRecyclerViewAdapter = ReviewGraphRecyclerViewAdapter(reviewGraphNumbers, reviewGraphBarValues, reviewGraphBarWidths)
        contentPlanDetailReviewGraphRecyclerView.adapter = reviewGraphRecyclerViewAdapter
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ContentPlanDetailActivity::class.java)
            context.startActivity(intent)
        }
    }
}