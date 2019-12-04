package com.example.triplan.ui.content_plan_detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.model.Review
import com.example.triplan.model.ReviewGraph
import kotlinx.android.synthetic.main.activity_content_plan_detail.*
import java.lang.Exception

class ContentPlanDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: ContentPlanDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_plan_detail)
        viewModel = ViewModelProviders.of(this).get(ContentPlanDetailViewModel::class.java)

        val packageNameInsta = "com.instagram.android"
        val classNameInsta = "com.instagram.android.activity.MainTabActivity"
        contentPlanDetailTextInst.setOnClickListener {
            intent.setClassName(packageNameInsta, classNameInsta)
            try {
                startActivity(intent)
            } catch (e: Exception) {
            }
        }
        contentPlanDetailBack.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }


        val reviewGraphs = listOf<ReviewGraph>()
        val reviewGraphRecyclerViewAdapter = ReviewGraphRecyclerViewAdapter(reviewGraphs)
        contentPlanDetailReviewGraphRecyclerView.adapter = reviewGraphRecyclerViewAdapter

        val reviewStarNum = 3.0f
        contentPlanDetailReviewValueNum.text = reviewStarNum.toString()
        val reviewStarRecyclerViewAdapter = ReviewStarRecyclerViewAdapter(reviewStarNum)
        contentPlanDetailReviewStarRecyclerView.adapter = reviewStarRecyclerViewAdapter

        viewModel.planStore.selectedSchedule.value?.let {
            viewModel.getPlanDetail(it.id, {
                val detail = it.data
                contentPlanDetailTextTitle.text = detail.title
                contentPlanDetailTextDescription.text = detail.body
                contentPlanDetailTextWeb.text = detail.link
                contentPlanDetailTextMapAddress.text = detail.address
                contentPlanDetailReviewValueNum.text = detail.review.toString()
                val reviewListRecyclerViewAdapter = ReviewListRecyclerViewAdapter(detail.userReviews.map {
                    Review(it.icon, it.sentence, it.body)
                })
                contentPlanDetailReviewRecyclerView.adapter = reviewListRecyclerViewAdapter
            }, {
                Toast.makeText(this, it.errorMessage(this), Toast.LENGTH_SHORT).show()
            })

        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ContentPlanDetailActivity::class.java)
            context.startActivity(intent)
        }
    }
}