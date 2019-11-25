package com.example.triplan.ui.content_plan_detail

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import kotlinx.android.synthetic.main.activity_content_plan_detail.*
import java.lang.Exception
import java.util.stream.Stream

data class Review(
    val image: Int,
    val comment: String
)
data class ReviewGraph(
    val number: Int,
    val value: Int
)

class ContentPlanDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_plan_detail)

        val packageNameInsta = "com.instagram.android"
        val classNameInsta = "com.instagram.android.activity.MainTabActivity"
        contentPlanDetailTextInst.setOnClickListener {
            intent.setClassName(packageNameInsta, classNameInsta)
            try {
                startActivity(intent)
            } catch (e: Exception) {
            }
        }

        val reviews = listOf<Review>()
        val reviewListRecyclerViewAdapter = ReviewListRecyclerViewAdapter(reviews)
        contentPlanDetailReviewRecyclerView.adapter = reviewListRecyclerViewAdapter

        val reviewGraphs = listOf<ReviewGraph>()
        val reviewGraphRecyclerViewAdapter = ReviewGraphRecyclerViewAdapter(reviewGraphs)
        contentPlanDetailReviewGraphRecyclerView.adapter = reviewGraphRecyclerViewAdapter

        val reviewStarNum = 3.0f
        contentPlanDetailReviewValueNum.text = reviewStarNum.toString()
        val reviewStarRecyclerViewAdapter = ReviewStarRecyclerViewAdapter(reviewStarNum)
        contentPlanDetailReviewStarRecyclerView.adapter = reviewStarRecyclerViewAdapter
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ContentPlanDetailActivity::class.java)
            context.startActivity(intent)
        }
    }
}