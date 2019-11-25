package com.example.triplan.api.model.Body

import com.example.triplan.model.Gender
import com.squareup.moshi.Json

data class SignUpBody(
    @Json(name = "name")
    val name: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String,
//    @Json(name = "line_id")
//    val lineId: Int,
//    @Json(name = "station_id")
//    val stationId: Int,
    @Json(name = "lineStationId")
    val stationLineId: Int,
    @Json(name = "age")
    val age: Int,
    @Json(name = "gender")
    val gender:  Int
) {
    companion object {
        fun setBody(
            name: String,
            password: String,
            email: String,
//            lineId: Int,
//            stationId: Int,
            stationLineId: Int,
            age: Int,
            genderType: Gender
        ): SignUpBody {
            return SignUpBody(name, email, password, stationLineId, age, genderType.value)
        }

    }
}
