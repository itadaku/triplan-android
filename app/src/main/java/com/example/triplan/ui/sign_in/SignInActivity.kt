package com.example.triplan.ui.sign_in

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.api.model.Body.SignInBody
import com.example.triplan.data.UserStore
import com.example.triplan.lib.RegexPattern
import com.example.triplan.lib.isMatch
import com.example.triplan.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    private lateinit var viewModel: SignInViewModel
    private val userStore = UserStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        viewModel = ViewModelProviders.of(this).get(SignInViewModel::class.java)

        userStore.user.observe(this, Observer {
            userStore.token.postValue(it.token)
        })

        userStore.token.observe(this, Observer {
            userStore.saveToken(applicationContext)
        })

        signInButton.setOnClickListener { view ->
            view.isEnabled = false
            val email = signInTextEmailForm.text.toString().trim()
            val password = signInTextPasswordForm.text.toString().trim()

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

            val signInBody = SignInBody(email, password)

            viewModel.sendSignInData(signInBody, {
                MainActivity.start(this)
            }, {
                Toast.makeText(this, it.errorMessage(this), Toast.LENGTH_SHORT).show()
                view.isEnabled = true
            })

        }
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SignInActivity::class.java)
            context.startActivity(intent)
        }
    }
}
