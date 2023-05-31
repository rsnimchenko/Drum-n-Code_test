package com.shooter.drumncode_test.domain.model_ui

import com.shooter.drumncode_test.domain.model_db.EventModelDB

data class EventModelUI(
    val eventId: String,
    val sportId: String,
    val eventName: String,
    val startTime: Long
)

fun EventModelUI.toDB() = EventModelDB(
    eventId = this.eventId,
    sportId = this.sportId,
    eventName = this.eventName,
    startTime = this.startTime
)