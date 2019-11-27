package com.example.triplan.ui.content_plan_traffic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.model.Traffic
import kotlinx.android.synthetic.main.item_content_plan_traffic.view.*
import kotlinx.android.synthetic.main.item_setting.view.*

class ContentPlanTrafficRecyclerViewAdapter(
    private val traffics: List<Traffic>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return traffics.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_content_plan_traffic)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.contentPlanTrafficTextDetail.text = traffics[position].detail
        holder.itemView.contentPlanTrafficTextStation.text = traffics[position].station
    }
}