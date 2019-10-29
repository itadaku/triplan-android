package com.example.triplan.ui.sign_up

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.triplan.R
import com.example.triplan.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_sing_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        val nearestStationLineSpinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            arrayOf("山手線", "京浜東北線", "中央線", "東海道線", "常磐線", "埼京線"))

        nearestStationLineSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        signUpSpinnerNearestStationLine.adapter =nearestStationLineSpinnerAdapter

        val nearestStationStationSpinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            (1..10).map { "${it}駅" }.toTypedArray())
        nearestStationStationSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        signUpSpinnerNearestStationStation.adapter = nearestStationStationSpinnerAdapter
        signUpButton.setOnClickListener {
            MainActivity.start(this)
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SignUpActivity::class.java)
            context.startActivity(intent)
        }
    }

}
