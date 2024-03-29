package com.example.triplan.ui.content_plan_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import com.example.triplan.model.Review
import kotlinx.android.synthetic.main.item_review.view.*

class ReviewListRecyclerViewAdapter(
    private val reviews: List<Review>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return reviews.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_review)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        reviews.getSafety(position)?.let {
            holder.itemView.reviewTitle.text = it.title
            holder.itemView.reviewComment.text = it.comment
        }

    }
}