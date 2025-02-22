package com.example.dogapiapplication

import kotlinx.serialization.Serializable


object Destinations {
    @Serializable object DogBreedsScreen
    @Serializable class DogImagesScreen(val breed: String)
}