package com.pranay.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
        Text(
            text = "You have had $count glasses.",
            modifier = modifier.padding(16.dp)
        )
        Button(onClick = { count++ }, modifier = modifier.padding(top = 8.dp)) {
            Text(
                text = "Add one",
            )
        }
    }
}