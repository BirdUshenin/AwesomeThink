package com.example.awesomethink

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.awesomethink.ui.theme.NameText
import com.example.awesomethink.ui.theme.TimeTable
import com.example.facebook.RootActivity
import com.example.material.MaterialActivity
import com.example.material.theme.AwesomeThinkTheme
import com.example.vkmiddle.VkMiddleActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            AwesomeThinkTheme {
                CardStructure {
                    val intent = Intent(this, VkMiddleActivity::class.java)
                    startActivity(intent)
                }
                ButtonToMaterial {
                    val intent = Intent(this, MaterialActivity::class.java)
                    startActivity(intent)
                }
                Facebook {
                    val intent = Intent(this, RootActivity::class.java)
                    startActivity(intent)
                }
                StateButton(viewModel)
            }
        }
    }
}

@Composable
fun StateButton(
    viewModel: MainViewModel
) {
    val isFollowed = viewModel.isFollowing.observeAsState(false)

    // naked without ViewModel state for Rotate

//    val isFollowed = rememberSaveable {
//        mutableStateOf(false)
//    }
    FollowButton(isFollowed = isFollowed.value) {
        viewModel.changeFollowingStatus()
    }
}

@Composable
fun FollowButton(
    isFollowed: Boolean,
    clickListener: () -> Unit
) {
    Button(
        onClick = { clickListener() },
        colors = ButtonDefaults.buttonColors(
            if (isFollowed) {
                MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
            } else {
                MaterialTheme.colorScheme.primary
            }
        ),
        modifier = Modifier.padding(start = 40.dp)
    ) {
        val text = if (isFollowed) {
            "unfollow"
        } else {
            "follow"
        }
        Text(text = text)
    }
}

//@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun CardStructure(
    onClick: () -> Unit
) {
    val navController = rememberNavController()
    Card(
        colors = cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 50.dp,
                start = 5.dp,
                end = 5.dp,
            ),
        shape = RoundedCornerShape(30.dp).copy(
            bottomStart = CornerSize(0.dp),
            bottomEnd = CornerSize(0.dp)
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 20.dp
                )
        ) {
            TimeTable()
        }

        Box(
            Modifier.padding(
                start = 20.dp,
                top = 20.dp
            )
        ) {
            NameText()
        }
        Button(
            onClick = {
                onClick()
            },
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        ) {
            Text(text = "Post")
        }

    }

}

@Composable
fun ButtonToMaterial(
    onClick: () -> Unit,
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .padding(start = 20.dp, top = 250.dp)
    ) {
        Text(text = "Go to Material")
    }
}

@Composable
fun Facebook(
    onClick: () -> Unit,
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .padding(
                start = 20.dp,
                top = 300.dp
            )
    ) {
        Text(text = "Facebook")
    }
}


//@Preview
//@Composable
//fun TextTest() {
//    Text(
//        text = "This is Text",
//        fontSize = 24.sp,
//        fontWeight = FontWeight.ExtraBold,
//        fontStyle = FontStyle.Italic,
//        fontFamily = FontFamily.Cursive,
//        color = Color.Red
//    )
//}

@Preview
@Composable
fun TextTest() {
    Text(
        buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("Hello")
            }
            append(" ")
            withStyle(SpanStyle(fontSize = 30.sp, color = Color.White)) {
                append("Row")
            }
        }
    )
}


//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun PreviewCardLight() {
    AwesomeThinkTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        CardStructure {}
    }
}

//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun PreviewCardNight() {
    AwesomeThinkTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        CardStructure {}
    }
}

