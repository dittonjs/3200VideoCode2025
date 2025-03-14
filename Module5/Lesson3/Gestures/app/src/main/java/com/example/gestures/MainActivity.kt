package com.example.gestures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.drag
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.tooling.preview.Preview
import com.example.gestures.ui.theme.GesturesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GesturesTheme {
                var down by remember { mutableStateOf(Offset(0f, 0f)) }
                var move by remember { mutableStateOf(Offset(0f, 0f)) }
                var up by remember { mutableStateOf(Offset(0f, 0f)) }
                Box(modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        awaitEachGesture {
                            val firstDown = awaitFirstDown()
                            down = firstDown.position
                            move = Offset(0f, 0f)
                            up = Offset(0f, 0f)

                            while(true) {
                                val event = awaitPointerEvent()
                                val change = event.changes.first()
                                if (change.pressed) {
                                    move += change.positionChange()
                                } else {
                                    up = change.position
                                    break
                                }
                            }
                        }
                    }
                ) {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = "Down: $down",
                            style = MaterialTheme.typography.headlineLarge,
                        )
                        Text(
                            text = "Move: $move",
                            style = MaterialTheme.typography.headlineLarge,
                        )
                        Text(
                            text = "Up: $up",
                            style = MaterialTheme.typography.headlineLarge,
                        )
                    }
                }
            }
        }
    }
}

