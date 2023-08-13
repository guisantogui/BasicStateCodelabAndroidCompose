package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun WaterCounter(modifier: Modifier = Modifier){

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        var count by remember { mutableStateOf(0) }

        if(count > 0){
            Text(text = "You've had $count glasses!",
                modifier = Modifier.padding(16.dp))
        }
        else{
            Text(text = "Start drinking water now!",
                modifier = Modifier.padding(16.dp))
        }

        ElevatedButton(
            onClick = { count++ },
            modifier = Modifier.padding(top = 8.dp),
            enabled = count <10
        ) {
            Text(text = "Add one glass!")
        }

        ElevatedButton(
            onClick = { count = 0 },
            modifier = Modifier.padding(top = 8.dp),
            enabled = count > 0
        ) {
            Text(text = "Clear count")
        }
    }

}


@Preview
@Composable
fun WaterCounterPreview(){
    WaterCounter()
}