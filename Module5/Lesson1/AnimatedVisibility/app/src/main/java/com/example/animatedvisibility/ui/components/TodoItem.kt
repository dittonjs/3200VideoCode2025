package com.example.animatedvisibility.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.animatedvisibility.models.Todo

@Composable
fun TodoItem(todo: Todo, toggleCompletion: () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp))
            .background(Color.White)

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    isVisible = !isVisible
                }
                .padding(8.dp),

            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = todo.title, modifier = Modifier.weight(1f))
            Checkbox(checked = todo.isDone, onCheckedChange = { toggleCompletion() })
        }
        AnimatedVisibility(
            visible = isVisible
        ) {
            HorizontalDivider(thickness = 2.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ){
                Text(text = todo.description)
            }
        }
    }
}