package com.example.triplan.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.triplan.R
import com.example.triplan.model.User

object UserStore {
    val user = MutableLiveData<User>()
    val token = MutableLiveData<String>()
    fun saveToken(context: Context) {
        val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        token.value?.let {
            sharedPreferences.edit()
                .putString(DataKey.TOKEN.key, it)
                .apply()
        }
    }

    fun setToken(context: Context) {
        val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val tokenData = sharedPreferences.getString(DataKey.TOKEN.key, "token") ?: "token"
        token.value = tokenData
    }
 }