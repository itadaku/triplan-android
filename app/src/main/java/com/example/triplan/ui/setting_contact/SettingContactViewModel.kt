package com.example.triplan.ui.setting_contact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SettingContactBody
import com.example.triplan.api.repository.SettingRepository
import com.example.triplan.model.SettingContact

class SettingContactViewModel: ViewModel() {
    private val settingRepository: SettingRepository = SettingRepository()
    val setting = MutableLiveData<SettingContact>()

    fun sendContent(settingContactBody: SettingContactBody): ApiResponse {
        var response: ApiResponse = ApiResponse.Failure(ApiResponse.ResponseType.Failure)
        settingRepository.sendContact(settingContactBody, {
            setting.postValue(it.data)
            response = it
        }, {
            response = it
        })
        return response
    }
}