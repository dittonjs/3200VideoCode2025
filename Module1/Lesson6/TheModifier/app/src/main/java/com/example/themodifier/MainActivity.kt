package com.example.themodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themodifier.ui.theme.TheModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheModifierTheme {
                Column(
                    Modifier
                        .fillMaxSize(.5f)
                        .padding(16.dp, 64.dp)
                        .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
                        .background(Color.LightGray)
                        .padding(16.dp)
                        .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
                        .background(Color.White)
                        .padding(16.dp)

                ){
                    Text("Hello, world!")
                }
            }
        }
    }
}
