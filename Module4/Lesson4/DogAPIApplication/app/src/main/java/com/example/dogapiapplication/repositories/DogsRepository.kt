package com.example.dogapiapplication.repositories

import com.example.dogapiapplication.datasources.DogDataSource
import com.example.dogapiapplication.datasources.DogRemoteDataSource

class DogsRepository(
    private val dogDataSource: DogDataSource
){
    suspend fun getDogBreeds() = dogDataSource.getDogBreeds()
    suspend fun getDogImages(breed: String) = dogDataSource.getDogImages(breed)
}