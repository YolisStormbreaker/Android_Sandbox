package com.yolisstorm.sandbox.data.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

class WellnessTask(
    val id: Int,
    val label: String,
    initialState: Boolean = false
) {
    var checked: Boolean by mutableStateOf(initialState)
}
