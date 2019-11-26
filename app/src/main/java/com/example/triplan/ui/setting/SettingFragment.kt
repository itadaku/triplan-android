package com.example.triplan.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.triplan.R
import com.example.triplan.ui.setting_contact.SettingContactActivity
import com.example.triplan.ui.setting_feedback.SettingFeedbackActivity
import kotlinx.android.synthetic.main.fragment_setting.*

data class SettingLists(
    val id: SettingListId,
    val name: String
)

enum class SettingListId(val value: Int) {
    EDIT_USER_INFORMATION(0),
    CONTACT(1),
    FEEDBACK(2),
    TERMS_OF_SERVICE(3)
}

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

        val settingLists = listOf<SettingLists>(
            SettingLists(SettingListId.EDIT_USER_INFORMATION, "ユーザ情報編集"),
            SettingLists(SettingListId.CONTACT, "ご意見・ご要望"),
            SettingLists(SettingListId.FEEDBACK, "不具合報告"),
            SettingLists(SettingListId.TERMS_OF_SERVICE, "利用規約")
        )
        val settingRecyclerViewAdapter = SettingRecyclerViewAdapter(settingLists)
        settingRecyclerViewAdapter.setOnItemClickListener(object : SettingRecyclerViewAdapter.OnItemClickListener {
            override fun onClick(view: View, data: SettingLists) {
                when(data.id) {
                    SettingListId.EDIT_USER_INFORMATION -> {

                    }
                    SettingListId.CONTACT -> {
                        SettingContactActivity.start(view.context)
                    }
                    SettingListId.FEEDBACK -> {
                        SettingFeedbackActivity.start(view.context)
                    }
                    SettingListId.TERMS_OF_SERVICE -> {

                    }
                }
            }
        })
        settingRecyclerView.adapter = settingRecyclerViewAdapter
    }
}
