package com.shooter.drumncode_test.data.local

import com.shooter.drumncode_test.domain.model_db.toUI
import com.shooter.drumncode_test.domain.model_ui.EventModelUI
import com.shooter.drumncode_test.domain.model_ui.toDB
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EventDatabaseRepository @Inject constructor(
    private val eventDao: EventDao
) {
    fun getEventsSpecifySport(sportId: String) =
        eventDao.getEventsSpecifySport(sportId).map { it.toUI() }

    suspend fun insertEvent(eventModelUI: EventModelUI) = eventDao.insert(eventModelUI.toDB())

    suspend fun deleteEvent(eventModelUI: EventModelUI) = eventDao.delete(eventModelUI.toDB())
}