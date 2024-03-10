package com.example.facebook

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun MainScreen(){
    Scaffold(
        bottomBar = {
            NavigationBar {
                val selectedPosition = remember {
                    mutableIntStateOf(0)
                }
                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favorite,
                    NavigationItem.Profile
                )
                items.forEachIndexed { index, it ->
                    NavigationBarItem(
                        selected = selectedPosition.intValue == index,
                        onClick = { selectedPosition.intValue = index },
                        icon = {
                            Icon(
                                it.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = stringResource(id = it.titleResId))
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Blue,
                            unselectedIconColor = Color.Black,
                            selectedTextColor = Color.Blue,
                            unselectedTextColor = Color.Black
                        )
                    )
                }
            }
        }
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = "this is SPARTA"
        )
    }
}