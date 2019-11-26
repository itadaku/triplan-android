package com.example.triplan.ui.setting_feedback

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.SettingBody
import com.example.triplan.api.repository.SettingRepository
import com.example.triplan.model.Setting

class SettingFeedbackViewModel: ViewModel() {
    private val settingRepository: SettingRepository = SettingRepository()
    val setting = MutableLiveData<Setting>()

    fun sendFeedbackData(
        settingFeedbackBody: SettingBody,
        success: ((ApiResponse.Success<Setting>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ): ApiResponse {
        var response: ApiResponse = ApiResponse.Failure(ApiResponse.ResponseType.Failure)
        settingRepository.sendContactData(settingFeedbackBody, {
            setting.postValue(it.data)
            success.invoke(it)
        }, {
            failure.invoke(it)
        })
        return response
    }

}