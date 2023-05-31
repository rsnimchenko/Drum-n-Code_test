package com.shooter.drumncode_test.ui.main_screen.event_list

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.shooter.drumncode_test.domain.model_ui.EventModelUI
import com.shooter.drumncode_test.domain.model_ui.SportModelUI

@Composable
fun EventList(
    sportModelUI: SportModelUI,
    vm: EventViewModel = hiltViewModel()
) {
    val savedEvents by vm.getEventFlow(sportModelUI.sportId).collectAsState(initial = listOf())
    val otherEvents = sportModelUI.events.filter { !savedEvents.contains(it) }

    EventsListSync(savedEvents = savedEvents, otherEvents = otherEvents, vm = vm)
}

@Composable
fun EventsListUnsync(
    savedEvents: List<EventModelUI>,
    otherEvents: List<EventModelUI>,
    vm: EventViewModel
) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(savedEvents + otherEvents) {
            EventComponent(
                eventModelUI = it,
                isActive = savedEvents.contains(it),
                addEventToDb = vm::addEventToDb,
                deleteEventFromDb = vm::deleteEventFromDb
            )
        }
    }
}

@Composable
fun EventsListSync(
    savedEvents: List<EventModelUI>,
    otherEvents: List<EventModelUI>,
    vm: EventViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
    ) {
        (savedEvents + otherEvents).forEach {
            EventComponent(
                eventModelUI = it,
                isActive = savedEvents.contains(it),
                addEventToDb = vm::addEventToDb,
                deleteEventFromDb = vm::deleteEventFromDb
            )
        }
    }
}

@Composable
fun EventsTwoListsSync(
    savedEvents: List<EventModelUI>,
    otherEvents: List<EventModelUI>,
    vm: EventViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
    ) {
        savedEvents.forEach {
            EventComponent(
                eventModelUI = it,
                isActive = true,
                addEventToDb = vm::addEventToDb,
                deleteEventFromDb = vm::deleteEventFromDb
            )
        }
        otherEvents.forEach {
            EventComponent(
                eventModelUI = it,
                isActive = false,
                addEventToDb = vm::addEventToDb,
                deleteEventFromDb = vm::deleteEventFromDb
            )
        }
    }
}