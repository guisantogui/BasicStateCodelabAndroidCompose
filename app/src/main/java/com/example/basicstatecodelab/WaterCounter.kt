package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatefullWaterCounter(modifier: Modifier = Modifier) {
    var water by rememberSaveable { mutableStateOf(0) }
    //var juice by rememberSaveable { mutableStateOf(0) }

    Column {
        StatelessWaterCounter(water, {water++}, modifier)
        //StatelessWaterCounter(juice, {juice++}, modifier)
    }
}

@Composable
fun StatelessWaterCounter(
    count: Int, onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text("You've had $count glasses.")
    }
    Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
        Text("Add one")
    }

}


@Preview
@Composable
fun WaterCounterPreview() {
    StatefullWaterCounter()
}