package com.example.triplan.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.triplan.R
import com.example.triplan.model.User

object UserStore {
    val user = MutableLiveData<User>()
    val token = MutableLiveData<String>()
    fun saveToken(context: Context) {
        val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        user.value?.let {
            sharedPreferences.edit()
                .putString(DataKey.TOKEN.key, it.token)
                .apply()
        }
    }

    fun setToken(context: Context) {
        val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val tokenData = sharedPreferences.getString(DataKey.TOKEN.key, "") ?: ""
        token.postValue(tokenData)
    }
 }