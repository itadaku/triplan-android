package com.example.triplan.lib

import com.example.triplan.api.model.TestJson
import com.example.triplan.model.Test

class JsonMapper {
    companion object {
        fun toMapping(json: TestJson): Test = Test(
            message = json.message,
            triplanMessage =  json.triplanMessage
        )
    }
}