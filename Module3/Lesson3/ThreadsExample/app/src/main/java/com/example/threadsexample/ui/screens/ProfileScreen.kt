package com.example.threadsexample.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier.padding(paddingValues)
    ){
        Text("Profile Screen")
    }
}