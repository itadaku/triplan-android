package com.example.triplan.ui.setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import com.example.triplan.model.SettingElement
import kotlinx.android.synthetic.main.item_setting.view.*


class SettingRecyclerViewAdapter(
    private val settingList: List<SettingElement>,
    private val itemOnClickListener: ((View, SettingElement) -> Unit)
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return settingList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_setting)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val settingElement = settingList.getSafety(position)
        holder.itemView.settingText.text = settingElement?.name
        holder.itemView.setOnClickListener { view ->
            settingList.getSafety(position)?.let {
                itemOnClickListener.invoke(view, it)
            }
        }
    }
}
