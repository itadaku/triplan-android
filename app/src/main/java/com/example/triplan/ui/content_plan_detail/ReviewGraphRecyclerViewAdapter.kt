package com.example.triplan.ui.content_plan_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.model.ReviewGraph
import kotlinx.android.synthetic.main.item_review.view.*
import kotlinx.android.synthetic.main.item_review_graph.view.*

class ReviewGraphRecyclerViewAdapter(
    private val reviewGraphs: List<ReviewGraph>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return reviewGraphs.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_review_graph)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.reviewGraphNumber.text = reviewGraphs[position].number.toString()
        val reviewGraphBarLayoutParams = holder.itemView.reviewGraphBar.layoutParams
        reviewGraphBarLayoutParams.width = reviewGraphs[position].value * 2
        holder.itemView.reviewGraphBar.layoutParams = reviewGraphBarLayoutParams
        holder.itemView.reviewGraphBarValue.text = reviewGraphs[position].value.toString()
    }
}