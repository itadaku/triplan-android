package com.example.triplan.ui.top

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import com.example.triplan.model.Plan
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.item_contents.view.*

class TopContentsRecyclerViewAdapter(
    private val plans: List<Plan>,
    private val setOnClickTopPlanContent: ((View, Plan) -> Unit)
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context: Context? = null
    override fun getItemCount(): Int {
        return plans.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context
        return ViewHolder.create(inflater, parent, R.layout.item_contents)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        plans.getSafety(position)?.let {plan ->
            val tags = plan.purpose
            val tagListRecyclerViewAdapter = TagListRecyclerViewAdapter(tags)
            holder.itemView.tagListRecyclerView.adapter = tagListRecyclerViewAdapter
            holder.itemView.contentTitleText.text = plan.title
            holder.itemView.contentReviewText.text = plan.review.toString()
            holder.itemView.contentPeopleText.text = "${plan.numberOfPeople}人"
            holder.itemView.contentPlaceText.text = plan.address
            holder.itemView.contentStaysText.text = "${plan.daysNights}泊${plan.daysNights + 1}日"
            holder.itemView.contentBudgetText.text = "¥${plan.minBudget} ~ ${plan.maxBudget}"
            holder.itemView.setOnClickListener {
                setOnClickTopPlanContent.invoke(it, plan)
            }
        }
    }
}