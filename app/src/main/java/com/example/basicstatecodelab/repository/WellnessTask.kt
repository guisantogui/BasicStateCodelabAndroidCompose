package com.example.basicstatecodelab.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class WellnessTask(
    val id: Int,
    val label: String,
    var initialCheck: Boolean = false
) {
    var checked by mutableStateOf(initialCheck)
}