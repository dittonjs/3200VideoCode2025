package com.example.scaffoldexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scaffoldexample.ui.screens.HomeScreen
import com.example.scaffoldexample.ui.screens.ProfileScreen
import com.example.scaffoldexample.ui.screens.SettingsScreen
import com.example.scaffoldexample.ui.theme.ScaffoldExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ScaffoldExampleTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text("Scaffold Example")
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            actions = {
                                IconButton(onClick = {navController.navigate(Destinations.Home)}) {
                                    Icon(Icons.Default.Home, "Home")
                                }
                                IconButton(onClick = {navController.navigate(Destinations.Profile)}) {
                                    Icon(Icons.Default.Person, "Profile")
                                }
                                IconButton(onClick = {navController.navigate(Destinations.Settings)}) {
                                    Icon(Icons.Default.Settings, "Settings")
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(navController, startDestination = Destinations.Home) {
                        composable<Destinations.Home> {
                            HomeScreen(innerPadding)
                        }
                        composable<Destinations.Profile> {
                            ProfileScreen(innerPadding)
                        }
                        composable<Destinations.Settings> {
                            SettingsScreen(innerPadding)
                        }
                    }
                }
            }
        }
    }
}
