package com.example.triplan.ui.suggest_area

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.api.model.Body.SuggestSecondBody
import com.example.triplan.ui.suggest_plan.SuggestPlanActivity
import kotlinx.android.synthetic.main.activity_suggest_area.*

class SuggestAreaActivity : AppCompatActivity() {
    lateinit var viewModel: SuggestAreaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggest_area)

        viewModel = ViewModelProviders.of(this).get(SuggestAreaViewModel::class.java)
        viewModel.getPlanProposeFirst({
            val suggestAreaRecyclerViewAdapter = SuggestAreaRecyclerViewAdapter(it.data, { view, suggestArea ->
                viewModel.planStore.suggestFirstBody.value?.let {
                    viewModel.planStore.suggestSecondBody.value = SuggestSecondBody(
                        suggestArea.id,
                        listOf(1),
                        it.fromDate,
                        it.toDate
                    )

                    SuggestPlanActivity.start(this)
                }


            })
            suggestAreaRecyclerView.adapter = suggestAreaRecyclerViewAdapter
        }, {
            Toast.makeText(this, it.errorMessage(this), Toast.LENGTH_SHORT).show()
            finish()
        })
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SuggestAreaActivity::class.java)
            context.startActivity(intent)
        }
    }
}