package com.yolisstorm.sandbox.data

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.yolisstorm.sandbox.data.models.WellnessTask
import com.yolisstorm.sandbox.ui.views.WellnessTaskItem

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedChanged: (task: WellnessTask, isChecked: Boolean) -> Unit,
    onCloseClicked: (task: WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = {
                    onCheckedChanged(task, it)
                },
                onClose = {
                    onCloseClicked(task)
                }
            )
        }
    }
}