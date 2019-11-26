package com.example.triplan.ui.setting_contact

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import android.content.Context
import android.content.Intent
import kotlinx.android.synthetic.main.activity_setting_contact.*

class SettingContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_contact)

        settingContactBack.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SettingContactActivity::class.java)
            context.startActivity(intent)
        }
    }
}