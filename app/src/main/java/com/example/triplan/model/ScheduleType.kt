package com.example.triplan.model

enum class ScheduleType(val value: Int){
    NOTHING(0),
    DETAIL(1),
    TRAFFIC(2);

    companion object {
        fun getScheduleType(typeValue: Int): ScheduleType {
            return when(typeValue) {
                DETAIL.value -> DETAIL
                TRAFFIC.value -> TRAFFIC
                else -> NOTHING
            }
        }
    }
}