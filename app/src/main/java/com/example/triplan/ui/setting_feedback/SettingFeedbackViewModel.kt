package com.example.triplan.ui.setting_feedback

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triplan.api.ApiResponse
import com.example.triplan.api.model.Body.FeedBackBody
import com.example.triplan.api.repository.CommonRepository
import com.example.triplan.model.Setting

class SettingFeedbackViewModel: ViewModel() {
    private val settingRepository: CommonRepository = CommonRepository()
    val setting = MutableLiveData<Setting>()

    fun sendFeedbackData(
        settingFeedbackBody: FeedBackBody,
        success: ((ApiResponse.Success<Setting>) -> Unit),
        failure: ((ApiResponse.Failure) -> Unit)
    ): ApiResponse {
        var response: ApiResponse = ApiResponse.Failure(ApiResponse.ResponseType.Failure)
        settingRepository.sendFeedbackData(settingFeedbackBody, {
            setting.postValue(it.data)
            success.invoke(it)
        }, {
            failure.invoke(it)
        })
        return response
    }

}