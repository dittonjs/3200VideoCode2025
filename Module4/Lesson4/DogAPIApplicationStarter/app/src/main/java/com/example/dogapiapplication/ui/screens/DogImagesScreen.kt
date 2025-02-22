package com.example.dogapiapplication.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.dogapiapplication.viewmodels.DogBreedsScreenViewModel
import com.example.dogapiapplication.viewmodels.DogImagesScreenViewModel

@Composable
fun DogImagesScreen(
    dogId: String,
    viewModel: DogImagesScreenViewModel = viewModel(factory = DogImagesScreenViewModel.Factory)
) {
    val dogImages by viewModel.dogImages.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.loadDogImages(dogId)
    }

    // Display the dog images
    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        items(dogImages) { dogImage ->
            // Display the dog image
            AsyncImage(
                model=dogImage.imageUrl,
                contentDescription = "Dog image",
            )
        }
    }
}