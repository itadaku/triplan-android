package com.example.triplan.api.model.Json

import com.example.triplan.model.ScheduleType
import com.squareup.moshi.Json
import java.util.Date

data class ScheduleJson(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "body")
    val body: String,
    @Json(name = "start_time")
    val startTime: String,
    @Json(name = "end_time")
    val endTime: String,
    @Json(name = "image_path")
    val imagePath: String,
    @Json(name = "type")
    val type: Int,
    @Json(name = "days")
    val days: Int
)