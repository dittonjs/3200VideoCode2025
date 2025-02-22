package com.example.dogapiapplication.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dogapiapplication.viewmodels.DogBreedsScreenViewModel

@Composable
fun DogBreedsScreen(
    onDogBreedSelected: (String) -> Unit,
    viewModel: DogBreedsScreenViewModel = viewModel(factory = DogBreedsScreenViewModel.Factory)
) {
    val breeds by viewModel.breeds.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.loadBreeds()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text("Dog Breeds", style = MaterialTheme.typography.titleLarge)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            items(breeds) { breed ->
                if (breed.subBreeds.isEmpty()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, MaterialTheme.colorScheme.onSurface, MaterialTheme.shapes.medium)
                            .padding(8.dp)
                            .clickable { onDogBreedSelected(breed.id) }
                    ){
                        Text(breed.name)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                } else {
                    for (subBreed in breed.subBreeds) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, MaterialTheme.colorScheme.onSurface, MaterialTheme.shapes.medium)
                                .padding(8.dp)
                                .clickable { onDogBreedSelected(breed.id) }
                        ){
                            Text(subBreed.name)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }

}