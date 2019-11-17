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
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ContentPlanDetailActivity::class.java)
            context.startActivity(intent)
        }
    }
}