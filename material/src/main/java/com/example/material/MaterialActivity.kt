package com.example.material

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.material.theme.AwesomeThinkTheme

class MaterialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AwesomeThinkTheme {
                Test()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Test() {
    ModalNavigationDrawer(
        drawerContent = {
            Column {
                Text(text = "Text1", color = Color.Red)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Text2", color = Color.Red)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Text3", color = Color.Red)
            }
        }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Material Activity")
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Menu, contentDescription = null)

                        }
                    }
                )
            },
            bottomBar = {
                val selectedItem by remember { mutableIntStateOf(0) }

                NavigationBar {

                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        label = { Text(text = "Search") },
                        icon = {
                            Icon(Icons.Filled.Search, contentDescription = null)
                        }
                    )
                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        label = { Text(text = "Favorite") },
                        icon = {
                            Icon(Icons.Filled.Favorite, contentDescription = null)
                        }
                    )
                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        label = { Text(text = "Setting") },
                        icon = {
                            Icon(Icons.Filled.Settings, contentDescription = null)
                        }
                    )
                }
            },
        ) {
            Text(
                modifier = Modifier.padding(it),
                text = "this is SPARTA"
            )
        }
    }
}
