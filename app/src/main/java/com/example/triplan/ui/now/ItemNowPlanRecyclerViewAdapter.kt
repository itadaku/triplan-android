package com.example.triplan.ui.now

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import com.example.triplan.model.Schedule
import kotlinx.android.synthetic.main.item_now_schedule.view.*
import java.text.SimpleDateFormat
import java.util.*

class ItemNowPlanRecyclerViewAdapter (
    private val schedules: List<Schedule>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return schedules.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_now_schedule)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        schedules.getSafety(position)?.let {
            val df = SimpleDateFormat("HH:mm:ss")

            holder.itemView.itemNowScheduleTitle.text = it.title
            holder.itemView.itemNowScheduleBodyText.text = it.body
            holder.itemView.itemNowScheduleFromTimeText.text = it.startTime
            holder.itemView.itemNowScheduleToTimeText.text = it.endTime
        }
    }
}