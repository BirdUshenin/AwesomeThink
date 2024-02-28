package com.example.vkfee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.awesomethink.ui.theme.AwesomeThinkTheme

class VkFeeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AwesomeThinkTheme {
                CardView()
            }
        }
    }

    @Preview
    @Composable
    fun CardView() {
        Card(
            modifier = Modifier
                .padding(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Green
            ),
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 5.dp, top = 5.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.twotone),
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                        .background(Color.Red),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = "Выпил пиво", fontSize = 22.sp)
                    Text(text = "14:00", fontSize = 22.sp, color = Color.Gray)
                }
            }
            Text(
                text = "Рекламная платформа Telegram откроется в почти ста новых странах. ",
                Modifier.padding(12.dp), fontSize = 15.sp
            )
            Image(
                painterResource(id = R.drawable.ads),
                contentDescription = null,
                Modifier.padding(start = 12.dp, end = 12.dp)
            )
            DownRow()
        }
    }

    @Preview
    @Composable
    fun DownRow() {
        Row(
            Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OneDown(left = "41 205")
            OneDown(left = "206")
            OneDown(left = "1206")
            OneDown(left = "26")
        }
    }

    @Composable
    fun OneDown(
        left: String
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top

        ) {
            Image(
                painterResource(id = R.drawable.twotone),
                contentDescription = null
            )
            Text(text = left)
        }
    }
}