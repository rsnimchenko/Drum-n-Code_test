package com.shooter.drumncode_test.ui.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    vm: MainScreenViewModel = hiltViewModel()
) {
    val currentTime = vm.currentTime.collectAsState()
    val sportsList = vm.sportsState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(items = sportsList.value) {
                SportLabelWithEvents(
                    sport = it,
                    currentTime = currentTime
                )
            }
        }
    }
}