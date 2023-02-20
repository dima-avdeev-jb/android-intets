package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(topBar = {
                        NavigationBar(containerColor = Color.Transparent) {
                            Box(Modifier.fillMaxSize()) {
                                Box(
                                    Modifier
                                        .fillMaxHeight()
                                        .align(Alignment.CenterEnd)
                                        .background(Color.LightGray)
                                ) {
                                    Text("NavigationBar",
                                        Modifier
                                            .align(Alignment.CenterEnd)
                                            .padding(start = 10.dp, end = 100.dp)
                                    )
                                }
                            }
                        }
                    }) {
                        Content()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content() {
    val t = remember { mutableStateOf("text state") }
    Box(
        Modifier
            .background(Color.Yellow)
            .displayCutoutPadding()
            .background(Color.Green)
            .statusBarsPadding()
            .background(Color.Blue)
            .navigationBarsPadding()//bottom
            .imePadding()//keyboard
            .background(Color.Red)
            .fillMaxSize()
    ) {
        Text(
            buildString { repeat(10) { appendLine("Up ${it + 1}") } },
            Modifier
                .align(Alignment.TopStart)
                .background(Color.LightGray)
        )
        TextField(
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

@Preview(showBackground = false, device = "id:pixel_5", showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Content()
    }
}
