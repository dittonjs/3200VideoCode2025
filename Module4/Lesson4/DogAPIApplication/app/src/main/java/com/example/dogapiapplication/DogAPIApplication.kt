package com.example.dogapiapplication

import android.app.Application
import com.example.dogapiapplication.datasources.DogRemoteDataSource
import com.example.dogapiapplication.repositories.DogsRepository

class DogAPIApplication: Application() {

    val dogsRepository: DogsRepository = DogsRepository(DogRemoteDataSource())

}