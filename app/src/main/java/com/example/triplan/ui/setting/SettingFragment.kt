package com.example.triplan.ui.setting

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.triplan.R
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val settingLists = resources.getStringArray(R.array.setting_item_array_text).toList()
        val settingRecyclerViewAdapter = SettingRecyclerViewAdapter(settingLists)
        settingRecyclerView.adapter = settingRecyclerViewAdapter
    }
}
