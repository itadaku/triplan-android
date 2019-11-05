package com.example.triplan.lib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    companion object {
        fun create(inflater: LayoutInflater, parent: ViewGroup?, res: Int): ViewHolder {
            return ViewHolder(inflater.inflate(res, parent, false))
        }
    }
}