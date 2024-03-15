package com.example.facebook

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebook.domain.StatisticItem
import com.example.facebook.domain.StatisticType
import java.lang.IllegalStateException

@Preview
@Composable
fun CardViewPost(
    modifier: Modifier = Modifier
) {
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        modifier = modifier
    ) {
        UpString()
        Image(
            painterResource(id = R.drawable.ads),
            contentDescription = null
        )
        Box(Modifier.padding(5.dp)) {
            Text(text = stringResource(R.string.telegram))
        }
        DownString()
    }
}

@Composable
fun UpString() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = R.drawable.share),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(R.string.share),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = stringResource(R.string.time))
        }
        Image(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null
        )
    }
}

@Composable
fun DownString(
//    statistics: List<StatisticItem>
) {
    Box(
        modifier = Modifier
            .padding(top = 10.dp)
            .border(
                width = 1.dp,
                color = Color.Gray,
            )
            .background(Color.LightGray)
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        start = 5.dp,
                        top = 5.dp,
                        bottom = 10.dp
                    )
            ) {
//                val viewItem = statistics.getItemByType(StatisticType.VIEWS)
                Text(
                    modifier = Modifier
                        .padding(
                            start = 5.dp
                        ),
                    text = stringResource(R.string.likes)
                )
                Image(
                    imageVector = Icons.Rounded.Favorite,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Red),
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 5.dp,
                        bottom = 10.dp,
                        end = 15.dp
                    ),
                horizontalArrangement = Arrangement.End
            ) {
                ImageWithText(
                    imageId = R.drawable.views,
                    text = "844K"
                )
                ImageWithText(
                    imageId = R.drawable.comment,
                    text = stringResource(R.string.comment_view)
                )
                ImageWithText(
                    imageId = R.drawable.send,
                    text = stringResource(R.string.send_view)
                )
            }
        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {

    return this.find { it.type == type } ?: throw IllegalStateException()
}
@Composable
fun ImageWithText(
    imageId: Int,
    text: String
) {
    Row(Modifier.padding(start = 15.dp)) {
        Icon(
            painter = painterResource(id = imageId),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = text
        )
    }
}