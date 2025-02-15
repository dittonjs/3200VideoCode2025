package com.example.threadsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.threadsexample.ui.screens.HomeScreen
import com.example.threadsexample.ui.screens.ProfileScreen
import com.example.threadsexample.ui.theme.ThreadsExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ThreadsExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController, startDestination = Destinations.Home) {
                        composable<Destinations.Home> {
                            HomeScreen(
                                goToProfile = {
                                    navController.navigate(Destinations.Profile)
                                },
                                paddingValues = innerPadding
                            )
                        }

                        composable<Destinations.Profile> {
                            ProfileScreen(paddingValues = innerPadding)
                        }
                    }
                }
            }
        }
    }
}
