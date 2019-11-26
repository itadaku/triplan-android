package com.example.triplan.ui.sign_up

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.api.model.Body.SignUpBody
import com.example.triplan.data.UserStore
import com.example.triplan.lib.RegexPattern
import com.example.triplan.model.Gender
import com.example.triplan.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var viewModel: SignUpViewModel
    private val userStore = UserStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)

        val nearestStationLineSpinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            arrayOf("山手線", "京浜東北線", "中央線", "東海道線", "常磐線", "埼京線"))

        nearestStationLineSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        signUpSpinnerNearestStationLine.adapter =nearestStationLineSpinnerAdapter

        val genderList = resources.getStringArray(R.array.sign_up_text_gender_form_array_text)
        val signUpSpinnerGenderAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, genderList)
        signUpSpinnerGender.adapter = signUpSpinnerGenderAdapter

        val nearestStationStationSpinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            (1..10).map { "${it}駅" }.toTypedArray())
        nearestStationStationSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        signUpSpinnerNearestStationStation.adapter = nearestStationStationSpinnerAdapter

        signUpButton.setOnClickListener { view ->
            view.isEnabled = false
            val name = signUpTextNameForm.text.toString().trim()
            val email = signUpTextEmailForm.text.toString().trim()
            val password = signUpTextPasswordForm.text.toString().trim()
            val age = signUpTextAgeForm.text.toString()
            val gender = Gender.values()[signUpSpinnerGender.selectedItemPosition]
            if (name.isEmpty()) {
                Toast.makeText(this, "名前を入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email.isEmpty() || Regex(RegexPattern.EMAIL).containsMatchIn(email).not()) {
                Toast.makeText(this, "メールアドレスを正しく入力してください", Toast.LENGTH_SHORT).show()
                view.isEnabled = true
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "パスワードを入力してください", Toast.LENGTH_SHORT).show()
                view.isEnabled = true
                return@setOnClickListener
            }

            if (age.isEmpty()) {
                Toast.makeText(this, "年齢を入力してください", Toast.LENGTH_SHORT).show()
                view.isEnabled = true
                return@setOnClickListener
            }

            val signUpBody = SignUpBody(name, email, password, 0, age.toInt(), gender.value)

            viewModel.sendSignUpData(signUpBody, {
                MainActivity.start(this)
            }, {response ->
                Toast.makeText(this, response.errorMessage(this), Toast.LENGTH_SHORT).show()
                view.isEnabled = true
            })
        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SignUpActivity::class.java)
            context.startActivity(intent)
        }
    }

}
