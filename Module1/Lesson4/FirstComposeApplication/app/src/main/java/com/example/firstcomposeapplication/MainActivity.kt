package com.example.firstcomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcomposeapplication.ui.components.Contact
import com.example.firstcomposeapplication.ui.theme.FirstComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val names = generateNamesList()

        enableEdgeToEdge()
        setContent {
            FirstComposeApplicationTheme {
                Box(modifier = Modifier.padding(16.dp, 64.dp)){
//                    //Works for small numbers of items, or for non
//                    // dynamic content that doesn't fit on the screen
//                    Column(
//                        modifier = Modifier
//                            .verticalScroll(rememberScrollState())
//                    ) {
//                        for (name in names) {
//                            Contact(name)
//                        }
//                    }
                    // works for large dynamic content
                    LazyColumn {
                        items(names, { it }) {
                            Contact(it)
                        }
                    }
                }
            }
        }
    }
}

fun generateNamesList(): List<String> {
    val list = mutableListOf<String>()
    for (i in 1..100000) {
        list.add("Person $i")
    }
    return list
}