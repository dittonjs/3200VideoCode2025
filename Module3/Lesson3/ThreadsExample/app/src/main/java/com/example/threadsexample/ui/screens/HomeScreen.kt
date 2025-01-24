package com.example.threadsexample.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(goToProfile: () -> Unit, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var timer by remember { mutableIntStateOf(0) }
        var text by remember { mutableStateOf("") }
        val coroutineScope = rememberCoroutineScope()
        Text("$timer", fontSize = 60.sp)
        Button(onClick = {
            coroutineScope.launch(Dispatchers.Main) {
                while(true) {
                    delay(1000)
                    timer++
                    println("I am in a coroutine!")
                }
            }
        }) {
            Text("Start Timer")
        }
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text("Enter text")
            }
        )
        Button(onClick = goToProfile) {
            Text("Go to Profile")
        }

    }
}