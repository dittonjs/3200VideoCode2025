package com.example.dogapiapplication.apis

import retrofit2.http.GET
import retrofit2.http.Path

class BreedsResponse(val message: Map<String, List<String>>, val status: String)

class DogImagesResponse(val message: List<String>, val status: String)

interface DogsService {
    @GET("breeds/list/all")
    suspend fun getDogBreeds(): BreedsResponse

    @GET("breed/{breed}/images")
    suspend fun getDogImages(@Path("breed") breed: String): DogImagesResponse
}