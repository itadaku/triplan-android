package com.example.triplan.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.triplan.R
import com.example.triplan.ui.community.CommunityFragment
import com.example.triplan.ui.now.NowFragment
import com.example.triplan.ui.setting.SettingFragment
import com.example.triplan.ui.suggest.SuggestFragment
import com.example.triplan.ui.top.TopFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var backToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getTest({
        }, {
            Toast.makeText(this, it.errorMessage(this), Toast.LENGTH_SHORT).show()
        })

        supportFragmentManager.beginTransaction()
            .replace(mainHostFragmentLayout.id, TopFragment())
            .commit()

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.main_navigation_top -> {
                    supportFragmentManager.beginTransaction()
                        .replace(mainHostFragmentLayout.id, TopFragment())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.main_navigation_suggest -> {
                    supportFragmentManager.beginTransaction()
                        .replace(mainHostFragmentLayout.id, SuggestFragment())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.main_navigation_now -> {
                    supportFragmentManager.beginTransaction()
                        .replace(mainHostFragmentLayout.id, NowFragment())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.main_navigation_community -> {
                    supportFragmentManager.beginTransaction()
                        .replace(mainHostFragmentLayout.id, CommunityFragment())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.main_navigation_setting -> {
                    supportFragmentManager.beginTransaction()
                        .replace(mainHostFragmentLayout.id, SettingFragment())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }

//        val navController = findNavController(mainHostFragment.id)
//        bottomNavigationView.setupWithNavController(navController)
//        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    override fun onBackPressed() {
        backToast?.let {
            if (it.view.isShown) {
                this.moveTaskToBack(true)
            }
        }

        backToast = Toast.makeText(this, "もう一度押すと終了します", Toast.LENGTH_SHORT)
        backToast?.show()
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}
