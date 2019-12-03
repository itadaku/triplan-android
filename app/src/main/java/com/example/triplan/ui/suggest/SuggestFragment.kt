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
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.api.model.Body.SuggestFirstBody
import com.example.triplan.ui.main.MainViewModel
import com.example.triplan.ui.suggest_area.SuggestAreaActivity
import kotlinx.android.synthetic.main.fragment_suggest.*
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

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.activity?.let {

            suggestTextTimeFromForm.setOnClickListener{
                val cal = Calendar.getInstance()
                val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, month)
                    cal.set(Calendar.DAY_OF_MONTH, day)
                    suggestTextTimeFromForm.text = SimpleDateFormat("YYYY-MM-dd").format(cal.time)
                }
                DatePickerDialog(this.requireContext(), dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
            }
            suggestTextTimeToForm.setOnClickListener{
                val cal = Calendar.getInstance()
                val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, month)
                    cal.set(Calendar.DAY_OF_MONTH, day)
                    suggestTextTimeToForm.text = SimpleDateFormat("YYYY-MM-dd").format(cal.time)
                }
                DatePickerDialog(this.requireContext(), dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
            }

            suggestButton.setOnClickListener {
                context?.let {
                    val budget = suggestTextBudgetForm.text.toString().trim()
                    val fromTimeText = suggestTextTimeFromForm.text.toString().trim()
                    val toTimeText = suggestTextTimeToForm.text.toString().trim()
                    if (budget.isEmpty()) {
                        Toast.makeText(it, "予算を正しく入力してください", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }

                    if (fromTimeText.isEmpty()) {
                        Toast.makeText(it, "開始日を正しく入力してください", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }

                    if (toTimeText.isEmpty()) {
                        Toast.makeText(it, "終了日を正しく入力してください", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }

                    val suggestFirstBody = SuggestFirstBody(
                        suggestAgricultureSwitch.isChecked,
                        suggestForestrySwitch.isChecked,
                        suggestFishingIndustrySwitch.isChecked,
                        suggestTextBudgetForm.text.toString().toInt(),
                        suggestTextTimeFromForm.text.toString(),
                        suggestTextTimeToForm.text.toString()
                    )
                    viewModel.planStore.suggestFirstBody.value = suggestFirstBody
                    SuggestAreaActivity.start(it)
                }
            }
        }
    }
}
