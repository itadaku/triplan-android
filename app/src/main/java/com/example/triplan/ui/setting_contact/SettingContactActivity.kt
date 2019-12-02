package com.example.triplan.ui.setting_contact

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import android.content.Context
import android.content.Intent
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.api.model.Body.SettingBody
import com.example.triplan.model.Setting
import kotlinx.android.synthetic.main.activity_setting_contact.*

class SettingContactActivity : AppCompatActivity() {
    private lateinit var viewModel: SettingContactViewModel
    private val setting = MutableLiveData<Setting>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_contact)

        viewModel = ViewModelProviders.of(this).get(SettingContactViewModel::class.java)

        settingContactBack.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        settingContactForm.setOnClickListener {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(it, 0)
            it.requestFocus()
        }

        settingContactButton.setOnClickListener { view ->
            view.isEnabled = false
            val text = settingContactText.text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(this, "文章を入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val settingContactBody = SettingBody(text)

            viewModel.sendContentData(settingContactBody, {
                Toast.makeText(this, "送信に成功しました", Toast.LENGTH_SHORT).show()
            }, {response ->
                Toast.makeText(this, response.errorMessage(this), Toast.LENGTH_SHORT).show()
                view.isEnabled = true
            })
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val settingContactConstraintLayout = findViewById<ConstraintLayout>(R.id.settingContactConstraintLayout)
        inputMethodManager.hideSoftInputFromWindow(settingContactConstraintLayout.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        settingContactConstraintLayout.requestFocus()
        return super.onTouchEvent(event)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SettingContactActivity::class.java)
            context.startActivity(intent)
        }
    }
}