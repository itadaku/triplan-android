package com.example.triplan.ui.setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import com.example.triplan.model.SettingElement
import com.example.triplan.ui.setting_contact.SettingContactActivity
import com.example.triplan.ui.setting_feedback.SettingFeedbackActivity
import kotlinx.android.synthetic.main.item_setting.view.*


class SettingRecyclerViewAdapter(
    private val settingLists: List<SettingElement>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var listener: OnItemClickListener

    override fun getItemCount(): Int {
        return settingLists.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        setOnItemClickListener(listener)
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_setting)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.settingText.text = settingLists.getSafety(position)?.name
        holder.itemView.setOnClickListener {
            listener.onClick(it, settingLists[position])
        }
    }

    interface OnItemClickListener {
        fun onClick(view: View, settingElement: SettingElement)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}
