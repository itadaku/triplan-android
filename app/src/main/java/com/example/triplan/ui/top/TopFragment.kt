package com.example.triplan.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.triplan.R
import kotlinx.android.synthetic.main.fragment_top.*

class TopFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val topContentsListRecyclerViewAdapter =  TopContentsListRecyclerViewAdapter()
        topContentsListRecyclerView.adapter = topContentsListRecyclerViewAdapter
    }

}
