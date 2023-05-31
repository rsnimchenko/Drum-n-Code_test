package com.shooter.drumncode_test.ui.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shooter.drumncode_test.R
import com.shooter.drumncode_test.domain.model_ui.SportModelUI
import com.shooter.drumncode_test.ui.main_screen.event_list.EventList

@Composable
fun SportLabelWithEvents(
    sport: SportModelUI
) {
    val isOpen = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        EachSportLabel(sport = sport, isOpen = isOpen)
        if(isOpen.value)
            EventList(sportModelUI = sport)
    }
}

@Composable
fun EachSportLabel(
    sport: SportModelUI,
    isOpen: MutableState<Boolean>,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .background(MaterialTheme.colors.secondary)
        .clickable { isOpen.value = !isOpen.value }
        .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = sport.sportName,
            color = MaterialTheme.colors.onSecondary,
            style = MaterialTheme.typography.h1
        )
        Icon(
            painter = painterResource(
                id = if (isOpen.value) R.drawable.expand_less else R.drawable.expand_more
            ),
            contentDescription = "label_arrow",
            tint = Color.White,
            modifier = Modifier.size(32.dp)
        )
    }
}

