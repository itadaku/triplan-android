package com.example.triplan.ui.content_plan_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import kotlinx.android.synthetic.main.item_review.view.*
import kotlinx.android.synthetic.main.item_review_graph.view.*

class ReviewGraphRecyclerViewAdapter(
    private val numbers: List<String>,
    private val bar_values: List<String>,
    private val bar_widths: List<Float>
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
        holder.itemView.reviewGraphBar.x = bar_widths[position]
        holder.itemView.reviewGraphBarValue.text = bar_values[position]
    }
}