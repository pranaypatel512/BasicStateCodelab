package com.pranay.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit
) {
    LazyColumn(
        modifier,
    ) {
        items(list,
            key = { item: WellnessTask -> item.id }) { item: WellnessTask ->
            WellnessTaskItem(taskName = item.label, onClose = { onCloseTask(item) })
        }
    }
}