package com.example.triplan.ui.setting_feedback

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.api.model.Body.SettingBody
import com.example.triplan.model.Setting
import kotlinx.android.synthetic.main.activity_setting_feedback.*

class SettingFeedbackActivity : AppCompatActivity() {
    private lateinit var viewModel: SettingFeedbackViewModel
    private val setting = MutableLiveData<Setting>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_feedback)

        viewModel = ViewModelProviders.of(this).get(SettingFeedbackViewModel::class.java)

        settingFeedbackBack.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        settingFeedbackText.setOnClickListener { view ->
            view.isEnabled = false
            val text = settingFeedbackText.text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(this, "文章を入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val settingFeedbackBody = SettingBody(text)

            viewModel.sendFeedbackData(settingFeedbackBody, {
                Toast.makeText(this, "送信に成功しました", Toast.LENGTH_SHORT).show()
            }, {response ->
                Toast.makeText(this, response.errorMessage(this), Toast.LENGTH_SHORT).show()
                view.isEnabled = true
            })
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SettingFeedbackActivity::class.java)
            context.startActivity(intent)
        }
    }
}