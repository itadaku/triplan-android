package com.example.triplan.ui.content_plan

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import com.example.triplan.model.Schedule
import kotlinx.android.synthetic.main.item_setting.view.*

class ContentPlanScheduleRecyclerViewAdapter (
    private val scheduleList: List<Schedule>,
    private val setOnItemClickListener: ((View, Schedule) -> Unit)
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return scheduleList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_setting)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        scheduleList.getSafety(position)?.let { schedule ->
            holder.itemView.settingText.text = schedule.title
            holder.itemView.setOnClickListener { setOnItemClickListener.invoke(it, schedule) }
        }
    }
}