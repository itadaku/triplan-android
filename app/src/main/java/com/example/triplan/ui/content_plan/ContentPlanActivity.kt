package com.example.triplan.ui.content_plan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.model.ScheduleType
import com.example.triplan.ui.content_plan_detail.ContentPlanDetailActivity
import com.example.triplan.ui.content_plan_traffic.ContentPlanTrafficActivity
import kotlinx.android.synthetic.main.activity_content_plan.*

class ContentPlanActivity : AppCompatActivity() {
    private lateinit var viewModel: ContentPlanViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_plan)

        contentPlanBack.setOnClickListener {
            finish()
        }

        viewModel = ViewModelProviders.of(this).get(ContentPlanViewModel::class.java)

        viewModel.planInfo.observe(this, Observer {
            val conetntPlanTagsRecyclerAdapter = ConetntPlanTagsRecyclerAdapter(it.plan.purpose)
            contentPlanTagsRecyclerView.adapter = conetntPlanTagsRecyclerAdapter
            contentPlanTitle.text = it.plan.title
            contentPlanDetailPeopleText.text = "${it.plan.numberOfPeople}人"
            contentPlanDetailStayText.text = "${it.plan.daysNights}泊${it.plan.daysNights + 1}日"
            contentPlanDetailMoneyText.text = "${it.plan.minBudget} ~ ${it.plan.maxBudget}円"
            contentPlanDetailLocationText.text = it.plan.address


            val contentPlanSchedulesRecyclerViewAdapter = ContentPlanSchedulesRecyclerViewAdapter(it.schedules, { view, schedule ->
                when(schedule.type) {
                    ScheduleType.DETAIL -> {
                        viewModel.planStore.selectedSchedule.value = schedule
                        ContentPlanDetailActivity.start(this)
                    }

                    ScheduleType.TRAFFIC -> {
                        viewModel.planStore.selectedSchedule.value = schedule
                        ContentPlanTrafficActivity.start(this)
                    }

                    else -> { }
                }
            })
            contentPlanSchedulesRecyclerView.adapter = contentPlanSchedulesRecyclerViewAdapter
        })

        val bundle = intent.extras
        bundle?.let {
            val planId = it.getInt(KEY_PLAN_ID)
            viewModel.getPlanInfo(planId, {
                setContentView(R.layout.activity_content_plan)
                viewModel.planInfo.postValue(it.data)

                contentPlanSuggestButton.setOnClickListener { view ->
                    viewModel.selectPlanNow(planId, {

                    }, {

                    })
                }
            }, { failure ->
                Toast.makeText(this, failure.errorMessage(this), Toast.LENGTH_SHORT).show()
            })
        }
    }

    companion object {
        const val KEY_PLAN_ID = "plan_id"

        fun start(context: Context) {
            val intent = Intent(context, ContentPlanActivity::class.java)
            context.startActivity(intent)
        }

        fun start(context: Context, bundle: Bundle) {
            val intent = Intent(context, ContentPlanActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }

    }
}