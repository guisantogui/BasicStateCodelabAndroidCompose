package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicstatecodelab.repository.WellnessTask


@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onClose: (WellnessTask) -> Unit,
    onCheckedChange: (WellnessTask, Boolean) -> Unit,
) {

    LazyColumn(
        modifier = modifier
        // state = rememberLazyListState() -- Implementação padrão
    ) {
        items(
            items = list,
            key = { task -> task.id } //it.id
        ) { taskItem -> // it
            StatelessWellnessTaskItem(
                taskName = taskItem.label,
                onClose = { onClose(taskItem) },
                isChecked = taskItem.checked,
                onCheckedTask =  { checked -> onCheckedChange(taskItem, checked) } )
        }
    }
}


@Preview
@Composable
fun WellnessTasksListPreview() {
    // WellnessTasksList(list = getWellnessTasks(), onClose = { })
}