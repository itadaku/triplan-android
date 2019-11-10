package com.example.triplan.ui.setting

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder


class SettingRecyclerViewAdapter(private val settingTextList: Array<String>):
        RecyclerView.Adapter<SettingRecyclerViewAdapter.SettingViewHolder>() {

    class SettingViewHolder(textView: ConstraintLayout) : RecyclerView.ViewHolder(textView) {
        val nameView: TextView = textView.findViewById(R.id.settingText)
    }

    override fun getItemCount() = settingTextList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingRecyclerViewAdapter.SettingViewHolder {
        Log.d("adapter_oncreate", "onCreateViewHolder()")
        val inflater = LayoutInflater.from(parent.context)
        val textView = inflater.inflate(R.layout.item_setting, parent, false) as ConstraintLayout
        return SettingViewHolder(textView)
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        Log.d("adapter_bind", "onBindViewHolder()")
        holder.nameView.text = settingTextList[position]
    }
}