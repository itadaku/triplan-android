package com.example.triplan.model


data class Schedule(
    val id: Int,
    val title: String,
    val body: String,
    val startTime: String,
    val endTime: String,
    val imagePath: String,
    val type: ScheduleType
)