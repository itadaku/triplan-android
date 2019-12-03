package com.example.triplan.ui.top

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import com.example.triplan.model.Plan
import com.example.triplan.model.TopPlan
import kotlinx.android.synthetic.main.item_top_contents_list.view.*

class TopContentsListRecyclerViewAdapter(
    private val topPlans: List<TopPlan>,
    private val setOnClickTopPlanContent: ((View, Plan) -> Unit)
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return topPlans.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_top_contents_list)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val topPlan = topPlans.getSafety(position)
        topPlan?.let {
            val topContentsRecyclerViewAdapter = TopContentsRecyclerViewAdapter(it.plans, setOnClickTopPlanContent)
            holder.itemView.topContentsRecyclerView.adapter = topContentsRecyclerViewAdapter
            holder.itemView.topContentsTitle.text = it.title
        }
    }
}