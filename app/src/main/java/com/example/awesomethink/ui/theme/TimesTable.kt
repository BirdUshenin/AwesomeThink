package com.example.awesomethink.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.awesomethink.R

@Preview
@Composable
fun TimeTable() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .background(color = Color.Yellow)
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
//            .size(50.dp)
                .padding(start = 10.dp)
                .width(40.dp)
                .height(50.dp)
                .background(color = Color.Yellow),
            contentAlignment = Alignment.Center,
        ) {
            ImageIcon()
        }
        UserStatistic(title = "Post", "123")
        UserStatistic(title = "Followers", "123")
        Content()
    }
}

@Composable
private fun UserStatistic(
    title: String,
    value: String
) {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = title,
            color = Color.Black
        )

        Text(
            text = value,
            color = Color.Red
        )
    }
}
@Composable
fun Content(){
    Column(
        modifier = Modifier
            .padding(end = 10.dp)
            .background(Color.Blue)

    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(color = Color.Red)
                .padding(start = 20.dp)
        ) {

        }
        Box(
            modifier = Modifier
//            .size(50.dp)
                .width(40.dp)
                .height(40.dp)
                .background(color = Color.Gray)
                .padding(start = 30.dp)


        ) {
        }
    }
}

@Composable
fun ImageIcon(){
    Image(
        painterResource(id = R.drawable.rabbit),
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Red),
        contentDescription = "",
        contentScale = ContentScale.Fit
    )
}

@Composable
fun NameText(){
    Text(text = "Name", color = Color.Green, fontSize = 12.sp)
}