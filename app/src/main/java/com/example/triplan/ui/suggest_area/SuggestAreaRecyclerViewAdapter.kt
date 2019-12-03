package com.example.triplan.ui.suggest_area

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triplan.R
import com.example.triplan.lib.ViewHolder
import com.example.triplan.lib.getSafety
import com.example.triplan.model.SuggestArea
import kotlinx.android.synthetic.main.item_suggest_area.view.*

class SuggestAreaRecyclerViewAdapter(
    private val suggestAreaList: List<SuggestArea>,
    private val itemOnClickListener: ((View, SuggestArea) -> Unit)
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return suggestAreaList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder.create(inflater, parent, R.layout.item_suggest_area)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        suggestAreaList.getSafety(position)?.let { suggestArea ->
            holder.itemView.itemSuggestAreNameText.text = suggestArea.name
            holder.itemView.itemSuggestAreScoreValueText.text = suggestArea.matchScore.toString()
            holder.itemView.itemSuggestArePopulationText.text = suggestArea.population
            holder.itemView.itemSuggestAreCongestionRateValueText.text = suggestArea.congestionRate.toString()
            holder.itemView.setOnClickListener { itemOnClickListener.invoke(it, suggestArea) }
        }
    }
}
