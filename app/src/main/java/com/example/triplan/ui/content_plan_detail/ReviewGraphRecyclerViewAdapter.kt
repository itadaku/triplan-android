package com.example.triplan.ui.content_plan_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import kotlinx.android.synthetic.main.item_review.view.*
import kotlinx.android.synthetic.main.item_review_graph.view.*

class ReviewGraphRecyclerViewAdapter(
    private val numbers: List<String>,
    private val barValues: List<String>,
    private val barWidths: List<Int>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_review_graph)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.reviewGraphNumber.text = numbers[position]
        val reviewGraphBarLayoutParams = holder.itemView.reviewGraphBar.layoutParams
        reviewGraphBarLayoutParams.width = barWidths[position]
        holder.itemView.reviewGraphBar.layoutParams = reviewGraphBarLayoutParams
        holder.itemView.reviewGraphBarValue.text = barValues[position]
    }
}