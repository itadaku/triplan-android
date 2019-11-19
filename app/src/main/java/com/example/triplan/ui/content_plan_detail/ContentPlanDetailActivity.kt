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

class ContentPlanDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_plan_detail)

        contentPlanDetailTextInst.text = Html.fromHtml(resources.getString(R.string.content_plan_detail_text_inst_text))
        contentPlanDetailTextInst.movementMethod = LinkMovementMethod.getInstance()

        val reviews = resources.getStringArray(R.array.review_comments)
            .toList()
        val reviewListRecyclerViewAdapter = ReviewListRecyclerViewAdapter(reviews)
        contentPlanDetailReviewRecyclerView.adapter = reviewListRecyclerViewAdapter

        val reviewGraphNumbers = resources.getStringArray(R.array.review_graph_numbers)
            .toList()
        val reviewGraphBarValues = resources.getStringArray(R.array.review_graph_bar_values)
            .toList()
        val reviewGraphBarWidths = resources.getStringArray(R.array.review_graph_bar_widths)
            .toList()
        val reviewGraphBarWidthsInt = reviewGraphBarWidths.map { it.toInt() }
        val reviewGraphRecyclerViewAdapter = ReviewGraphRecyclerViewAdapter(reviewGraphNumbers, reviewGraphBarValues, reviewGraphBarWidthsInt)
        contentPlanDetailReviewGraphRecyclerView.adapter = reviewGraphRecyclerViewAdapter
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ContentPlanDetailActivity::class.java)
            context.startActivity(intent)
        }
    }
}