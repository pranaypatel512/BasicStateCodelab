package com.pranay.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessCounter(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember { mutableStateOf(0) }
        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(taskName = "Have you taken your 15 minute walk today?", onClose = {
                    showTask = false
                })
            }
            Text(
                text = "You have had $count glasses.",
                modifier = modifier.padding(16.dp)
            )
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text(
                    text = "Add one",
                )
            }
            Button(
                onClick = { count = 0 },
                modifier = modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = "Clear water count",
                )
            }
        }
    }
}

@Composable
fun WellnessTaskItem(taskName: String, onClose: () -> Unit, modifier: Modifier = Modifier) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = modifier
                .weight(1f)
                .padding(16.dp),
            text = taskName
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}