package com.example.triplan.ui.content_plan_traffic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import kotlinx.android.synthetic.main.item_content_plan_traffic.view.*
import kotlinx.android.synthetic.main.item_setting.view.*

class ContentPlanTrafficRecyclerViewAdapter(
    private val contentPlanTrafficDetailLists: List<String>,
    private val contentPlanTrafficStationLists: List<String>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return contentPlanTrafficDetailLists.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_content_plan_traffic)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.contentPlanTrafficTextDetail.text = contentPlanTrafficDetailLists[position]
        holder.itemView.contentPlanTrafficTextStation.text = contentPlanTrafficStationLists[position]
    }
}