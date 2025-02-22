package com.example.dogapiapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dogapiapplication.DogAPIApplication
import com.example.dogapiapplication.models.Breed
import com.example.dogapiapplication.repositories.DogsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogBreedsScreenViewModel(
    val dogsRepository: DogsRepository,
): ViewModel() {
    private val _breeds = MutableStateFlow(emptyList<Breed>())
    val breeds: StateFlow<List<Breed>> = _breeds

    fun loadBreeds() {
        // uncomment after implementing the repository
        viewModelScope.launch {
            _breeds.value = dogsRepository.getDogBreeds()
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as DogAPIApplication
                DogBreedsScreenViewModel(
                    dogsRepository = application.dogsRepository
                )
            }
        }
    }
}