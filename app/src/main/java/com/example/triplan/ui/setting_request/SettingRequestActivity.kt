package com.example.triplan.ui.setting_request

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.api.model.Body.RequestBody
import com.example.triplan.model.Setting
import kotlinx.android.synthetic.main.activity_setting_request.*

class SettingRequestActivity : AppCompatActivity() {
    private lateinit var viewModel: SettingRequestViewModel
    private val setting = MutableLiveData<Setting>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_request)

        viewModel = ViewModelProviders.of(this).get(SettingRequestViewModel::class.java)

        settingRequestBack.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        settingRequestForm.setOnClickListener {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(it, 0)
            it.requestFocus()
        }

        settingRequestButton.setOnClickListener { view ->
            view.isEnabled = false
            val text = settingRequestText.text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(this, "文章を入力してください", Toast.LENGTH_SHORT).show()
                view.isEnabled = true
                return@setOnClickListener
            }

            val settingRequestBody = RequestBody(text)

            viewModel.sendRequestData(settingRequestBody, {
                Toast.makeText(this, "送信に成功しました", Toast.LENGTH_SHORT).show()
            }, {response ->
                Toast.makeText(this, response.errorMessage(this), Toast.LENGTH_SHORT).show()
                view.isEnabled = true
            })
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val settingRequestConstraintLayout = findViewById<ConstraintLayout>(R.id.settingRequestConstraintLayout)
        inputMethodManager.hideSoftInputFromWindow(settingRequestConstraintLayout.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        settingRequestConstraintLayout.requestFocus()
        return super.onTouchEvent(event)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SettingRequestActivity::class.java)
            context.startActivity(intent)
        }
    }
}