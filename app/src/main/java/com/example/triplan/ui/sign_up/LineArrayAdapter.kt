package com.example.triplan.ui.sign_up

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.triplan.R
import com.example.triplan.lib.getSafety
import com.example.triplan.model.Line

class LineArrayAdapter (
    context: Context,
    private val viewResources: Int,
    private var dropdownViewResources : Int,
    private val lines: List<Line>
): ArrayAdapter<Line>(context, viewResources, lines) {

    init {
        this.setDropDownViewResource(dropdownViewResources)
    }

    override fun getCount(): Int  = lines.size

    override fun getItem(position: Int): Line? = lines.getSafety(position)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val line = lines.getSafety(position)
        val view = when (convertView) {
            null -> {
                val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                layoutInflater.inflate(viewResources, null)
            }

            else -> convertView
        }

        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text =line?.name

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val line = lines.getSafety(position)
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
                textView.text = line?.name
            }

            else -> { }
        }

        return view
    }

    override fun setDropDownViewResource(resource: Int) {
        dropdownViewResources = resource
        super.setDropDownViewResource(dropdownViewResources)
    }

}