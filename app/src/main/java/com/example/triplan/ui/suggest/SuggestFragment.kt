package com.example.triplan.ui.suggest

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.ui.main.MainViewModel
import java.text.SimpleDateFormat
import java.time.MonthDay
import java.util.Calendar
import kotlin.math.min

class SuggestFragment: Fragment() {
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_suggest, container, false)
        val textViewFromTime = view.findViewById<TextView>(R.id.suggestTextTimeFromForm)
        val textViewToTime = view.findViewById<TextView>(R.id.suggestTextTimeToForm)
        textViewFromTime.setOnClickListener{
            val cal = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, day)
                textViewFromTime.text = SimpleDateFormat("YYYY/MM/dd").format(cal.time)
            }
            DatePickerDialog(this.requireContext(), dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
        }
        textViewToTime.setOnClickListener{
            val cal = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, day)
                textViewToTime.text = SimpleDateFormat("YYYY/MM/dd").format(cal.time)
            }
            DatePickerDialog(this.requireContext(), dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.activity?.let {

        }
    }
}
