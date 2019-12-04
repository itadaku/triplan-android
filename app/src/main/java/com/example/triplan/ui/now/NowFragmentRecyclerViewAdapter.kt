package com.example.triplan.ui.now

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import com.example.triplan.model.Schedules
import kotlinx.android.synthetic.main.item_now_plan.view.*

class NowFragmentRecyclerViewAdapter(
    private val schedulesList: List<Schedules>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return schedulesList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_now_plan)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        schedulesList.getSafety(position)?.let { schedules ->
            holder.itemView.itemNowPlanDaysText.text = "${schedules.days}Days"
            holder.itemView.itemNowPlanRecyclerView.adapter = ItemNowPlanRecyclerViewAdapter(schedules.schedules)
        }

    }
}