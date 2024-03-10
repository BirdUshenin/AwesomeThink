package com.example.material

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.material.theme.AwesomeThinkTheme

class MaterialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AwesomeThinkTheme {
                Text(
                    text = "Hello"
                )
            }
        }
    }
}