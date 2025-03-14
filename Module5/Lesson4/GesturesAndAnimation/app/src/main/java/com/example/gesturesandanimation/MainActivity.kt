package com.example.gesturesandanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.gesturesandanimation.ui.theme.GesturesAndAnimationTheme
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GesturesAndAnimationTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    val configuration = LocalConfiguration.current
                    val screenWidth = configuration.screenWidthDp
                    val screenHeight = configuration.screenHeightDp
                    val density = LocalDensity.current.density
                    val coroutineScope = rememberCoroutineScope()

                    val xPos = remember { Animatable(0f) }
                    val yPos = remember { Animatable(0f) }

                    Box(
                        modifier = Modifier
                            .offset(screenWidth.dp / 2 - 50.dp, screenHeight.dp / 2 - 50.dp)
                            .graphicsLayer {
                                scaleX = 1f + xPos.value.absoluteValue / 100
                                scaleY = 1f + yPos.value.absoluteValue / 100
                            }
                            .size(100.dp)
                            .shadow(2.dp, RoundedCornerShape(8.dp))
                            .background(Color(63, 172, 131, 255))
                            .pointerInput(Unit) {
                                awaitEachGesture {
                                    awaitFirstDown()
                                    while (true) {
                                        val event = awaitPointerEvent()
                                        val change = event.changes.first()
                                        if (change.pressed) {
                                            coroutineScope.launch {
                                                xPos.snapTo(xPos.value + (change.positionChange().x / density))
                                                yPos.snapTo(yPos.value + (change.positionChange().y / density))
                                            }
                                        } else {
                                            coroutineScope.launch {
                                                xPos.animateTo(0f)
                                            }
                                            coroutineScope.launch {
                                                yPos.animateTo(0f)
                                            }
                                        }
                                    }
                                }
                            }

                    ) {
                    }
                }
            }
        }
    }
}

