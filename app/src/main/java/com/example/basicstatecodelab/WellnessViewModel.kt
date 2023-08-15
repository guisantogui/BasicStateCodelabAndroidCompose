package com.example.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.basicstatecodelab.repository.WellnessTask

class WellnessViewModel: ViewModel() {
    private val _tasksDb = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasksDb
    fun remove(item: WellnessTask){
        _tasksDb.remove(item)
    }
    fun changeTaskChecked(taskId: Int, checked: Boolean){
        _tasksDb.find { it.id == taskId }?.let { t -> t.checked = checked }
    }
}


private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
