package com.example.triplan.lib

import com.example.triplan.api.model.Json.*
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
            lineStationId = json.lineStationId,
            gender = Gender.values()[json.gender],
            token = json.token
        )

        fun toMapping(json: LineJson) = Line(
            id =  json.id,
            name = json.name
        )

        fun toMapping(json: LinesJson) = Lines(
            json.lines.map { Line(it.id, it.name) }.toList()
        )

        fun toMapping(json: StationJson) = Station(
            id =  json.id,
            name = json.name
        )

        fun toMapping(json: StationsJson) = Stations (
            json.stations.map { Station(it.id, it.name) }.toList()
        )

        fun toMapping(json: PlanJson) = Plan(
            json.id,
            json.title,
            json.image,
            json.review,
            json.daysNights,
            json.minBudget,
            json.maxBudget,
            json.numberOfPeople,
            json.purpose
        )

        fun toMapping(json: TopPlanJson) = TopPlan(
            json.title,
            json.plans.map {
                Plan(
                    it.id,
                    it.title,
                    it.image,
                    it.review,
                    it.daysNights,
                    it.minBudget,
                    it.maxBudget,
                    it.numberOfPeople,
                    it.purpose
                )}.toList()
        )

        fun toMapping(json: List<TopPlanJson>) = json.map { topPlanJson ->
            TopPlan(topPlanJson.title, topPlanJson.plans.map{
                Plan(
                    it.id,
                    it.title,
                    it.image,
                    it.review,
                    it.daysNights,
                    it.minBudget,
                    it.maxBudget,
                    it.numberOfPeople,
                    it.purpose)
            }.toList())
        }.toList()

        fun toMapping(json: PlanInfoJson): PlanInfo {
            val plan = Plan(
                json.plan.id,
                json.plan.title,
                json.plan.image,
                json.plan.review,
                json.plan.daysNights,
                json.plan.minBudget,
                json.plan.maxBudget,
                json.plan.numberOfPeople,
                json.plan.purpose)

            val schedulesList = mutableListOf<Schedules>()
            for (i in 1..json.plan.daysNights) {
                val days = i
                val scheduleList = json.schedules
                    .filter{ it.days == i}
                    .map {
                        Schedule(
                            it.id,
                            it.title,
                            it.body,
                            it.startTime,
                            it.endTime,
                            it.imagePath,
                            ScheduleType.getScheduleType(it.type) )}
                    .toList()
                schedulesList.add(Schedules(days, scheduleList))
            }
            return PlanInfo(plan, schedulesList)
        }

        fun toMapping(json: RequestJson) = Setting(
            done = json.done
        )

        fun toMapping(json: FeedBackJson) = Setting(
            done = json.done
        )
    }

}
