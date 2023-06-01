package com.shooter.drumncode_test.ui.main_screen.event_list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.shooter.drumncode_test.domain.model_ui.EventModelUI
import com.shooter.drumncode_test.domain.model_ui.SportModelUI

@Composable
fun EventList(
    sportModelUI: SportModelUI,
    currentTime: State<Long>,
    vm: EventViewModel = hiltViewModel()
) {
    val savedEvents by vm.getEventFlow(sportModelUI.sportId).collectAsState(initial = listOf())
    val otherEvents = sportModelUI.events.filter { !savedEvents.contains(it) }

    EventsList(
        savedEvents = savedEvents,
        otherEvents = otherEvents,
        currentTime = currentTime,
        vm = vm
    )
}

@Composable
fun EventsList(
    savedEvents: List<EventModelUI>,
    otherEvents: List<EventModelUI>,
    currentTime: State<Long>,
    vm: EventViewModel
) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(savedEvents + otherEvents) {
            EventComponent(
                eventModelUI = it,
                isActive = savedEvents.contains(it),
                currentTime = currentTime,
                addEventToDb = vm::addEventToDb,
                deleteEventFromDb = vm::deleteEventFromDb
            )
        }
    }
}