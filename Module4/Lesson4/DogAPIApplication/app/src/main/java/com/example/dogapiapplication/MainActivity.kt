package com.example.dogapiapplication

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
import androidx.navigation.toRoute
import com.example.dogapiapplication.ui.screens.DogBreedsScreen
import com.example.dogapiapplication.ui.screens.DogImagesScreen
import com.example.dogapiapplication.ui.theme.DogAPIApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            DogAPIApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController,
                        startDestination = Destinations.DogBreedsScreen,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Destinations.DogBreedsScreen> {
                            DogBreedsScreen(onDogBreedSelected = { breedId ->
                                navController.navigate(Destinations.DogImagesScreen(breedId))
                            })
                        }
                        composable<Destinations.DogImagesScreen> {
                            val route = it.toRoute<Destinations.DogImagesScreen>()
                            DogImagesScreen(route.breed)
                        }
                    }
                }
            }
        }
    }
}
