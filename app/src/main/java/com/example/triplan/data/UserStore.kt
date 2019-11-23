package com.example.triplan.data

import android.content.Context
import com.example.triplan.R
import com.example.triplan.model.User

class UserStore {
     companion object {
         fun saveToken(context: Context, token: String) {
            val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
            sharedPreferences.edit()
                .putString(DataKey.TOKEN.key, token)
                .apply()
         }

         fun saveUserId(context: Context, user: User) {
             val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
             sharedPreferences.edit()
                 .putLong(DataKey.USER_ID.key, user.id)
                 .apply()
         }

         fun getToken(context: Context): String {
             val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
             return sharedPreferences.getString(DataKey.TOKEN.key, "") ?: ""
         }

         fun getUserId(context: Context): Long {
             val sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
             return sharedPreferences.getLong(DataKey.USER_ID.key, 0)
         }
     }
 }