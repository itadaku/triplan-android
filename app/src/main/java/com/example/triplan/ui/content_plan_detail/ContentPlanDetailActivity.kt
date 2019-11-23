package com.example.triplan.ui.content_plan_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Html
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import kotlinx.android.synthetic.main.activity_content_plan_detail.*
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

        contentPlanDetailTextInst.text = Html.fromHtml(resources.getString(R.string.content_plan_detail_text_inst_text))
        contentPlanDetailTextInst.movementMethod = LinkMovementMethod.getInstance()

        val reviews = listOf<Review>()
        val reviewListRecyclerViewAdapter = ReviewListRecyclerViewAdapter(reviews)
        contentPlanDetailReviewRecyclerView.adapter = reviewListRecyclerViewAdapter

        val reviewGraphs = listOf<ReviewGraph>()
        val reviewGraphRecyclerViewAdapter = ReviewGraphRecyclerViewAdapter(reviewGraphs)
        contentPlanDetailReviewGraphRecyclerView.adapter = reviewGraphRecyclerViewAdapter
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ContentPlanDetailActivity::class.java)
            context.startActivity(intent)
        }
    }
}