package com.example.triplan.ui.suggest

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.triplan.R
import com.example.triplan.ui.time_picker.TimePickerFragment
import java.text.SimpleDateFormat
import java.time.MonthDay
import java.util.*
import kotlin.math.min

class SuggestFragment: Fragment(),TimePickerFragment.OnTimeSelectedListener,View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_suggest, container, false)
        val textViewFrom = view.findViewById<TextView>(R.id.suggestTextTimeFromForm)
        textViewFrom.setOnClickListener{
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                textViewFrom.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
        val button02 = view.findViewById<TextView>(R.id.suggestTextTimeFromForm)
        button02.setOnClickListener(new View.OnClickListener(){
            override fun onClick(View view) {

                val timePicker = TimePickerFragment()
                val fragmentManager = getFragmentManager()
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.su)
                timePicker.show(supportFragmentManager, "time_picker")
            }
        })
        */
    }

    override fun onClick(p0: View?) {
        //val manager = activity.supportFragmentManager
        val timePicker = TimePickerFragment()
        val fragmentManager = getFragmentManager()
        val transaction = fragmentManager?.beginTransaction()
        //transaction.replace(R.id.su)
        transaction?.add(R.id.suggestFragmentLayout, timePicker)
        transaction?.commit()
        //timePicker.show(manager, "time_picker")
    }

    override fun onSelected(hour: Int, minute: Int) {
        print(hour)
        print(minute)
    }
}
