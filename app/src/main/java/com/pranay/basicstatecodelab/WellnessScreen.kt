package com.pranay.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StateFullCounter()
        val list = wellnessViewModel.tasks
        WellnessTaskList(list = list, onCloseTask = { wellnessViewModel.remove(it) },
            onCheckedTask = { wellnessTask: WellnessTask, checked: Boolean ->
                wellnessViewModel.changedTaskChecked(wellnessTask, checked)
            }
        )
    }
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    StateFullCounter(modifier)
}

@Composable
fun StateFullCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StateLessCounter(count = count, onIncrement = { count++ }, modifier)
}

@Composable
fun StateLessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(
                text = "You have had $count glasses.",
                modifier = modifier.padding(16.dp)
            )
        }
        Button(
            onClick = onIncrement,
            modifier = modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text(
                text = "Add one",
            )
        }
    }
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

