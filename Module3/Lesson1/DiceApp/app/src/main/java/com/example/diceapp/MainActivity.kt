package com.example.diceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.diceapp.ui.screens.DiceRoleScreen
import com.example.diceapp.ui.screens.DiceSelectionScreen
import com.example.diceapp.ui.theme.DiceAppTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            DiceAppTheme {
                Box(modifier = Modifier
                    .safeDrawingPadding()
                    .padding(16.dp, 32.dp)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Destinations.Page1()
                    ) {
                        composable<Destinations.Page1> {
                            Button(onClick = {
                                navController.navigate(Destinations.Page2())
                            }) {
                                Text("Go to page 2")
                            }
                        }

                        composable<Destinations.Page2> {
                            Button(onClick = {
                                navController.popBackStack()
                            }) {
                                Text("Go back to page 1")
                            }
                        }
                    }
                }
            }
        }
    }
}
