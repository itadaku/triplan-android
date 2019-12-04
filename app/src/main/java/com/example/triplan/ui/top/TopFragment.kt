package com.example.triplan.ui.top

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.model.Plan
import com.example.triplan.model.TopPlan
import com.example.triplan.ui.content_plan.ContentPlanActivity
import com.example.triplan.ui.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_top.*

class TopFragment: Fragment() {
    lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        return inflater.inflate(R.layout.fragment_top, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.activity?.let {fragmentActivity ->
            viewModel.planStore.topPlans.observe(fragmentActivity, Observer { topPlans ->
                val topContentsListRecyclerViewAdapter =  TopContentsListRecyclerViewAdapter(topPlans, { view, plan ->
                    context?.let {
                        val bundle = Bundle()
                        bundle.putInt(ContentPlanActivity.KEY_PLAN_ID, plan.id)
                        ContentPlanActivity.start(it, bundle)
                    }
                })

                topContentsListRecyclerView.adapter = topContentsListRecyclerViewAdapter
            })
        }


        viewModel.getTopPlans({ }, { failure ->
            context?.let {
                Toast.makeText(it, failure.errorMessage(it), Toast.LENGTH_SHORT).show()
            }
        })
    }

}
