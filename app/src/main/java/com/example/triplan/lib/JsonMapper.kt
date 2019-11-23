package com.example.triplan.lib

import com.example.triplan.api.model.Json.LineJson
import com.example.triplan.api.model.Json.StationJson
import com.example.triplan.api.model.Json.TestJson
import com.example.triplan.api.model.Json.UserJson
import com.example.triplan.model.*

class JsonMapper {
    companion object {
        fun toMapping(json: TestJson) = Test(
            message = json.message,
            triplanMessage =  json.triplanMessage
        )

        fun toMapping(json: UserJson)  = User(
            id = json.id,
            name = json.name,
            email = json.email,
            age =  json.age,
            nearestStation = json.nearestStation,
            gender = Gender.valueOf(json.gender.toString()),
            token = json.token
        )

        fun toMapping(json: LineJson) = Line(
            id =  json.id,
            name = json.name
        )

        fun toMapping(json: StationJson) = Station(
            id =  json.id,
            name = json.name
        )
    }
}
