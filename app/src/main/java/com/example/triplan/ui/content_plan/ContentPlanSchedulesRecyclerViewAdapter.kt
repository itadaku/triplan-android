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
import com.example.triplan.model.Schedules
import kotlinx.android.synthetic.main.item_content_plan_schedule.view.*

class ContentPlanSchedulesRecyclerViewAdapter (
    val schedulesList: List<Schedules>,
    private val setOnItemClickListener: ((View, Schedule) -> Unit)
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return schedulesList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_content_plan_schedule)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        schedulesList.getSafety(position)?.let {
            Log.d("ccc", it.schedules.toString())
            holder.itemView.contentPlanScheduleDateText.text = "${it.days} Day"
            val contentPlanScheduleRecyclerViewAdapter = ContentPlanScheduleRecyclerViewAdapter(it.schedules, setOnItemClickListener)
            holder.itemView.contentPlanScheduleRecyclerView.adapter = contentPlanScheduleRecyclerViewAdapter
        }


    }
}