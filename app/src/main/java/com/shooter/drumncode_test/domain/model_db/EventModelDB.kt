package com.shooter.drumncode_test.domain.model_db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shooter.drumncode_test.domain.model_ui.EventModelUI

@Entity(tableName = "event")
data class EventModelDB(
    @PrimaryKey
    val eventId: String,
    val sportId: String,
    val eventName: String,
    val startTime: Long
)

fun EventModelDB.toUI() = EventModelUI(
    eventId = this.eventId,
    sportId = this.sportId,
    eventName = this.eventName,
    startTime = this.startTime
)

fun List<EventModelDB>.toUI() = this.map { it.toUI() }