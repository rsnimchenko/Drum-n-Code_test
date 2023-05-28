package com.shooter.drumncode_test.domain.model_api

import com.google.gson.annotations.SerializedName
import com.shooter.drumncode_test.domain.model_ui.SportModelUI

data class SportModelAPI(
    @SerializedName("i")
    val sportId: String? = null,
    @SerializedName("d")
    val sportName: String? = null,
    @SerializedName("e")
    val events: List<EventModelAPI>? = null
)

fun SportModelAPI.toUI() = SportModelUI(
    sportId = this.sportId ?: "",
    sportName = this.sportName ?: "",
    events = this.events?.toUI() ?: listOf()
)

fun List<SportModelAPI>.toUI() = this.map { it.toUI() }
