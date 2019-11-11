package com.example.triplan.ui.top

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import kotlinx.android.synthetic.main.item_top_contents.view.*

class TopContentsRecyclerViewAdapter(
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_top_contents)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val tags = arrayListOf("海", "リゾート", "国内")
        val tagListRecyclerViewAdapter = TagListRecyclerViewAdapter(tags)
        holder.itemView.tagListRecyclerView.adapter = tagListRecyclerViewAdapter
    }
}