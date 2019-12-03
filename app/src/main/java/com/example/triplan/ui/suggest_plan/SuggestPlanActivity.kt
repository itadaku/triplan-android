package com.example.triplan.ui.suggest_plan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.ui.content_plan.ContentPlanActivity
import kotlinx.android.synthetic.main.activity_suggest_plan.*

class SuggestPlanActivity : AppCompatActivity() {
    private lateinit var viewModel: SuggestPlanViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggest_plan)

        viewModel = ViewModelProviders.of(this).get(SuggestPlanViewModel::class.java)

        viewModel.getPlanProposeSecond({
            val suggestPlanRecyclerViewAdapter = SuggestPlanRecyclerViewAdapter(it.data, { view, plan ->
                val bundle = Bundle()
                bundle.putInt(ContentPlanActivity.KEY_PLAN_ID, plan.id)
                ContentPlanActivity.start(this, bundle)
            })
            suggestPlanRecyclerView.adapter = suggestPlanRecyclerViewAdapter
        }, {
            Toast.makeText(this, it.errorMessage(this), Toast.LENGTH_SHORT).show()
            finish()
        })
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SuggestPlanActivity::class.java)
            context.startActivity(intent)
        }
    }
}