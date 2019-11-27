package com.example.triplan.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.triplan.R
import com.example.triplan.model.SettingElement
import com.example.triplan.model.SettingElementId
import com.example.triplan.ui.setting_contact.SettingContactActivity
import com.example.triplan.ui.setting_feedback.SettingFeedbackActivity
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val settingLists = listOf<SettingElement>(
            SettingElement(SettingElementId.EDIT_USER_INFORMATION, "ユーザ情報編集"),
            SettingElement(SettingElementId.CONTACT, "ご意見・ご要望"),
            SettingElement(SettingElementId.FEEDBACK, "不具合報告"),
            SettingElement(SettingElementId.TERMS_OF_SERVICE, "利用規約")
        )
        val settingRecyclerViewAdapter = SettingRecyclerViewAdapter(settingLists)
        settingRecyclerViewAdapter.setOnItemClickListener(object : SettingRecyclerViewAdapter.OnItemClickListener {
            override fun onClick(view: View, settingElement: SettingElement) {
                when(settingElement.id) {
                    SettingElementId.EDIT_USER_INFORMATION -> {

                    }
                    SettingElementId.CONTACT -> {
                        SettingContactActivity.start(view.context)
                    }
                    SettingElementId.FEEDBACK -> {
                        SettingFeedbackActivity.start(view.context)
                    }
                    SettingElementId.TERMS_OF_SERVICE -> {

                    }
                }
            }
        })
        settingRecyclerView.adapter = settingRecyclerViewAdapter
    }
}
