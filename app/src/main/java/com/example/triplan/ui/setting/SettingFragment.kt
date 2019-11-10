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

    var settingTextList: Array<String> = Array<String>(13, { i -> i.toString() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)
        Log.d("SettingFragment", "onCreateView()")
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("SettingFragment", "onActivityCreated()")
        val settingRecyclerViewAdapter = SettingRecyclerViewAdapter(settingTextList)
        settingRecyclerView.adapter = settingRecyclerViewAdapter
    }
}
