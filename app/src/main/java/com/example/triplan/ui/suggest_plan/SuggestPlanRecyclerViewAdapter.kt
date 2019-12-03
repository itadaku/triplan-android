package com.example.triplan.ui.suggest_plan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import com.example.triplan.model.Plan
import com.example.triplan.ui.top.TagListRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_suggest_plan_contents.view.*

class SuggestPlanRecyclerViewAdapter(
    private val plans: List<Plan>,
    private val onItemClickListener: ((View, Plan) -> Unit)
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return plans.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_suggest_plan_contents)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        plans.getSafety(position)?.let { plan ->
            val tagListRecyclerViewAdapter = TagListRecyclerViewAdapter(plan.purpose)
            holder.itemView.tagListRecyclerView.adapter = tagListRecyclerViewAdapter
            holder.itemView.contentTitleText.text = plan.title
            holder.itemView.contentReviewText.text = plan.review.toString()
            holder.itemView.contentPeopleText.text = "${plan.numberOfPeople}人"
            holder.itemView.contentPlaceText.text = plan.address
            holder.itemView.contentStaysText.text = "${plan.daysNights}泊${plan.daysNights + 1}日"
            holder.itemView.contentBudgetText.text = "¥${plan.minBudget} ~ ${plan.maxBudget}"
            holder.itemView.setOnClickListener{ onItemClickListener.invoke(it, plan) }
        }
    }
}