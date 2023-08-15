package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {

    Column(
        modifier = modifier
    ) {
        StatefullWaterCounter()

        val list = remember { wellnessViewModel.tasks }
        WellnessTasksList(list = list,
            onClose =
            { task ->
                wellnessViewModel.remove(task)
            },
            onCheckedChange =
            { task, checked ->
                wellnessViewModel.changeTaskChecked(task.id, checked)
            }
        )
    }

}
