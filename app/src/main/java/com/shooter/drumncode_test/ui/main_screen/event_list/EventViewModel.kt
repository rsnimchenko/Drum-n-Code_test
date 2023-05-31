package com.shooter.drumncode_test.ui.main_screen.event_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shooter.drumncode_test.data.local.EventDatabaseRepository
import com.shooter.drumncode_test.domain.model_ui.EventModelUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val eventDatabaseRepository: EventDatabaseRepository
): ViewModel() {

    fun getEventFlow(sportId: String) = eventDatabaseRepository.getEventsSpecifySport(sportId)

    fun addEventToDb(eventModelUI: EventModelUI) {
        viewModelScope.launch {
            eventDatabaseRepository.insertEvent(eventModelUI)
        }
    }

    fun deleteEventFromDb(eventModelUI: EventModelUI) {
        viewModelScope.launch {
            eventDatabaseRepository.deleteEvent(eventModelUI)
        }
    }
}