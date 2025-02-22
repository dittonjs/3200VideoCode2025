package com.example.dogapiapplication.datasources


import com.example.dogapiapplication.models.Breed
import com.example.dogapiapplication.models.DogImage

interface DogDataSource {
    suspend fun getDogBreeds(): List<Breed>
    suspend fun getDogImages(breed: String): List<DogImage>
}