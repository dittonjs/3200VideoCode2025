package com.example.dogapiapplication.datasources

import com.example.dogapiapplication.apis.DogsService
import com.example.dogapiapplication.models.Breed
import com.example.dogapiapplication.models.DogImage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogRemoteDataSource: DogDataSource {
    private val api = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = api.create(DogsService::class.java)

    override suspend fun getDogBreeds(): List<Breed> {
        val response = service.getDogBreeds()
        val breeds = response.message.map { (breed, subBreeds) ->
            Breed(breed, subBreeds.map { Breed(it) })
        }
        return breeds
    }

    override suspend fun getDogImages(breed: String): List<DogImage> {
        val response = service.getDogImages(breed)
        val images = response.message.map { DogImage(it) }
        return images
    }
}