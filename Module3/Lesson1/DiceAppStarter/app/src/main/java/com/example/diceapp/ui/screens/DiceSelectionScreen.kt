package com.example.diceapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DiceSelectionScreen(goToDiceRole: (Int) -> Unit) {
    val dice = remember { listOf(4,6,8,10,12,20) }

    Column {
        Text("Select a die to roll", fontSize = 32.sp)
        Spacer(Modifier.height(8.dp))
        for (die in dice) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, RoundedCornerShape(4.dp))
                .background(Color.White)
                .clickable {
                    goToDiceRole(die)
                }
                .padding(8.dp)
            ){
                Text("$die-sided die")
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}