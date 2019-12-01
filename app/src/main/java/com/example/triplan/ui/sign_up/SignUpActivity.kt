package com.example.triplan.ui.sign_up

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.api.model.Body.SignUpBody
import com.example.triplan.data.UserStore
import com.example.triplan.lib.RegexPattern
import com.example.triplan.lib.isMatch
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

        userStore.user.observe(this, Observer {
            userStore.token.postValue(it.token)
        })

        userStore.token.observe(this, Observer {
            userStore.saveToken(applicationContext)
        })

        viewModel.line.observe(this, Observer {
            val position = signUpSpinnerNearestStationLine.selectedItemPosition
            val adapter = signUpSpinnerNearestStationLine.adapter as LineArrayAdapter
            viewModel.line.value?.let { line ->
                // apiを叩いて、station adapterに値をセットする
                viewModel.getStations(line, {
                    val stations = it.data.stations
                    val stationsArrayAdapter = StationArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item,
                        R.layout.item_spinner_dropdown,
                        stations)
                    signUpSpinnerNearestStationStation.adapter = stationsArrayAdapter
                }, {
                    Toast.makeText(this, it.errorMessage(this), Toast.LENGTH_SHORT).show()
                })
            }
        })

        viewModel.getLines({
            val lines = it.data.lines
            val nearestStationLineSpinnerAdapter = LineArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                R.layout.item_spinner_dropdown,
                lines
            )
            signUpSpinnerNearestStationLine.adapter =nearestStationLineSpinnerAdapter
        }, {
            Toast.makeText(this, it.errorMessage(this), Toast.LENGTH_SHORT).show()
        })

        val genderList = resources.getStringArray(R.array.sign_up_text_gender_form_array_text)
        val signUpSpinnerGenderAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, genderList)
        signUpSpinnerGender.adapter = signUpSpinnerGenderAdapter

        signUpSpinnerNearestStationLine.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (signUpSpinnerNearestStationLine.adapter) {
                    is LineArrayAdapter -> {
                        val adapter = signUpSpinnerNearestStationLine.adapter as LineArrayAdapter
                        val line = adapter.getItem(position)
                        line?.let {
                            viewModel.line.value = it
                        }
                    }
                    else -> {

                    }
                }
            }
        }

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

            if (email.isEmpty() || email.isMatch(RegexPattern.EMAIL).not()) {
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
