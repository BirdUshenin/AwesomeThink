package com.example.awesomethink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomethink.ui.theme.AwesomeThinkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeTable()
        }
    }
}

@Preview
@Composable
fun TimeTable() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        for (i in 1 until 10) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                for (j in 1 until 10) {
                    val color =  if ((i + j) % 2 == 0 ){
                        Color.Yellow
                    } else {
                        Color.White
                    }
                    Box (modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(color = color)
                        .border(width = 1.dp, color = Color.Black),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "${j * i}", color = Color.Red)
                    }
                }
            }
        }
    }
}

