package com.example.triplan.ui.sign_in

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.api.model.Body.SignInBody
import com.example.triplan.lib.RegexPattern
import com.example.triplan.lib.isMatch
import com.example.triplan.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    private lateinit var viewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        viewModel = ViewModelProviders.of(this).get(SignInViewModel::class.java)
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
                Log.d("aaa", "name: ${it.data.name} email: ${it.data.email}")
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
