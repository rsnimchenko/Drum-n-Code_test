package com.shooter.drumncode_test.domain.model_api

import com.google.gson.annotations.SerializedName
import com.shooter.drumncode_test.domain.model_ui.EventModelUI

data class EventModelAPI(
    @SerializedName("i")
    val eventId: String? = null,
    @SerializedName("si")
    val sportId: String? = null,
    @SerializedName("d")
    val eventName: String? = null,
    @SerializedName("tt")
    val startTime: String? = null
)

fun EventModelAPI.toUI() = EventModelUI(
    eventId = this.eventId ?: "",
    sportId = this.sportId ?: "",
    eventName = this.eventName ?: "",
    startTime = this.startTime ?: ""
)

fun List<EventModelAPI>.toUI() = this.map { it.toUI() }
