package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Content()
        }
    }
}

@Composable
fun Content() {
    val t = remember { mutableStateOf("text state") }
    Box(
        Modifier
            .background(Color.Yellow)
            .displayCutoutPadding()//cutout
            .statusBarsPadding()
            .background(Color.Blue)
            .navigationBarsPadding()//bottom
            .imePadding()//keyboard
            .background(Color.LightGray)
            .fillMaxSize()
    ) {
        Text(
            buildString { repeat(10) { appendLine("Up ${it + 1}") } },
            Modifier
                .align(Alignment.TopStart)
                .background(Color.LightGray)
        )
        BasicTextField(
            t.value, { t.value = it },
            Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
        )
        Text(
            buildString { repeat(10) { appendLine("Down ${it + 1}") } },
            Modifier
                .align(Alignment.BottomStart)
                .background(Color.LightGray)
        )
    }
}

