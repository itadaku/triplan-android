package com.example.triplan.ui.top

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import kotlinx.android.synthetic.main.item_tag.view.*

class TagListRecyclerViewAdapter(
    private val tags: List<String>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_tag)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        tags.getSafety(position)?.let {
            holder.itemView.tagItem.text = it
        }
    }
}