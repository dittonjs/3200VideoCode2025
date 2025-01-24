package com.example.scaffoldexample.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingsScreen(padding: PaddingValues) {
    Text(
        modifier = Modifier.padding(padding),
        text = "Settings Screen"
    )
}