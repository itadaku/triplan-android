package com.example.triplan.ui.sign_up

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.triplan.R
import com.example.triplan.lib.getSafety
import com.example.triplan.model.Station

class StationArrayAdapter (
    context: Context,
    private val viewResources: Int,
    private val dropdownViewResources: Int,
    private val stations: List<Station>
): ArrayAdapter<Station>(context, viewResources, stations) {
    override fun getCount(): Int  = stations.size

    override fun getItem(position: Int): Station? = stations.getSafety(position)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.d("aaa", stations.toString())
        val station = stations.getSafety(position)
        val view = when(convertView) {
            null -> {
                val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                layoutInflater.inflate(viewResources, null)
            }

            else -> convertView
        }

        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text =station?.name

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val stations = stations.getSafety(position)

        val view = when (convertView) {
            null -> {
                val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                layoutInflater.inflate(dropdownViewResources, null)
            }

            else -> convertView
        }

        when (dropdownViewResources) {
            R.layout.item_spinner_dropdown -> {
                val textView = view.findViewById<TextView>(R.id.spinnerItemTextView)
                textView.text = stations?.name
            }

            else -> { }
        }

        return view
    }
}