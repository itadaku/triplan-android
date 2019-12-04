package com.example.triplan.ui.now

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.ui.content_plan.ConetntPlanTagsRecyclerAdapter
import com.example.triplan.ui.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_now.*

class NowFragment: Fragment() {
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        return inflater.inflate(R.layout.fragment_now, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        this.activity?.let {
            when (viewModel.planStore.nowPlans.value) {
                null -> {
                    viewModel.getPlanNow({
                        val planInfo = it.data
                        contentPlanTagsRecyclerView.adapter = ConetntPlanTagsRecyclerAdapter(planInfo.plan.purpose)
                        contentPlanDetailPeopleText.text = "${planInfo.plan.numberOfPeople}人"
                        contentPlanDetailStayText.text = "${planInfo.plan.daysNights}泊${planInfo.plan.daysNights + 1}日"
                        contentPlanDetailMoneyText.text = "${planInfo.plan.minBudget} ~ ${planInfo.plan.maxBudget}円"
                        contentPlanDetailLocationText.text = planInfo.plan.address
                        nowFragmentRecyclerView.adapter = NowFragmentRecyclerViewAdapter(planInfo.schedules)

                        viewModel.planStore.nowPlans.value = planInfo
                    }, {failure ->
                        context?.let {
                            Toast.makeText(it, failure.errorMessage(it), Toast.LENGTH_SHORT).show()
                        }
                    })
                }

                else -> {
                    viewModel.planStore.nowPlans.value?.let { planInfo ->
                        contentPlanTagsRecyclerView.adapter = ConetntPlanTagsRecyclerAdapter(planInfo.plan.purpose)
                        contentPlanDetailPeopleText.text = "${planInfo.plan.numberOfPeople}人"
                        contentPlanDetailStayText.text = "${planInfo.plan.daysNights}泊${planInfo.plan.daysNights + 1}日"
                        contentPlanDetailMoneyText.text = "${planInfo.plan.minBudget} ~ ${planInfo.plan.maxBudget}円"
                        contentPlanDetailLocationText.text = planInfo.plan.address
                        nowFragmentRecyclerView.adapter = NowFragmentRecyclerViewAdapter(planInfo.schedules)
                    }
                }
            }

        }
    }
}

// y5zJpG22a3SDhX1hNMzh4MfZevDJbkEP
// w2EcqlIXHGojQdaT30yrzAsJCSunnEtW
