package com.shooter.drumncode_test.ui.main_screen.event_list

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shooter.drumncode_test.R
import com.shooter.drumncode_test.domain.model_ui.EventModelUI
import java.time.Duration
import java.time.Instant
import kotlin.math.abs

@Composable
fun EventComponent(
    eventModelUI: EventModelUI,
    isActive: Boolean,
    currentTime: State<Long>,
    addEventToDb: (EventModelUI) -> Unit,
    deleteEventFromDb: (EventModelUI) -> Unit
) {
    val itemWidthDp = remember { mutableStateOf(0.dp) }
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                if (isActive) deleteEventFromDb(eventModelUI) else addEventToDb(eventModelUI)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimeEvent(
            startTime = eventModelUI.startTime,
            itemWidthDp = itemWidthDp,
            currentTime = currentTime.value
        )
        StarIcon(isActive = isActive)
        EventName(
            eventName = eventModelUI.eventName,
            itemWidthDp = itemWidthDp
        )
    }
}

@Composable
fun TimeEvent(
    startTime: Long,
    currentTime: Long,
    itemWidthDp: MutableState<Dp>,
    modifier: Modifier = Modifier
) {
    val duration = Duration.between(Instant.ofEpochSecond(startTime), Instant.ofEpochMilli(currentTime))

    val seconds = duration.seconds
    val absSeconds = abs(seconds)
    val positive = String.format(
        "%d:%02d:%02d",
        absSeconds / 3600,
        absSeconds % 3600 / 60,
        absSeconds % 60
    )
    val localDensity = LocalDensity.current

    Text(
        text = if (seconds > 0) "-$positive" else positive,
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.body1,
        modifier = modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.onBackground,
                shape = MaterialTheme.shapes.small
            )
            .padding(4.dp)
            .onGloballyPositioned {
                itemWidthDp.value = with(localDensity) { it.size.width.toDp() }
            }
    )
}

@Composable
fun EventName(
    eventName: String,
    itemWidthDp: MutableState<Dp>,
    modifier: Modifier = Modifier
) {
    val eventNames = eventName.split(" - ")
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = eventNames.getOrElse(0) { "" },
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.widthIn(max = itemWidthDp.value)
        )
        Text(
            text = eventNames.getOrElse(1) { "" },
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.widthIn(max = itemWidthDp.value)
        )
    }
}

@Composable
fun StarIcon(
    isActive: Boolean,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(
            id = if (isActive) R.drawable.star_active else R.drawable.star_inactive
        ),
        contentDescription = "star_icon",
        modifier = modifier.size(32.dp),
        tint = if (isActive) Color.Yellow else Color.Gray
    )
}