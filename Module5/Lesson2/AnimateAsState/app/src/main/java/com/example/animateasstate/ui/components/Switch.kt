package com.example.animateasstate.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp


@Composable
fun Switch() {
    var isOn by remember { mutableStateOf(false) }
    val xPosition by animateDpAsState(
        targetValue = if (isOn) 54.dp else 4.dp,
        label = "xPosition",
        animationSpec = spring(
            stiffness = 1000f,
            dampingRatio = .7f
        )
    )

    Row(
        modifier = Modifier
            .width(108.dp)
            .height(58.dp)
            .border(1.dp, Color(63, 200, 175, 255), RoundedCornerShape(4.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ){
                isOn = !isOn
            }
    ){
        Box (
            Modifier
                .size(50.dp)
                .offset {
                    IntOffset(xPosition.roundToPx(), 4.dp.roundToPx())
                }
                .background(Color(63, 200, 175, 255), RoundedCornerShape(4.dp))
        ){
            Text(xPosition.toString())
        }
    }
}