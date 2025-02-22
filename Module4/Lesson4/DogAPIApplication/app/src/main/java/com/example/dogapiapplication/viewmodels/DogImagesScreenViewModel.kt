package com.example.dogapiapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dogapiapplication.DogAPIApplication
import com.example.dogapiapplication.models.Breed
import com.example.dogapiapplication.models.DogImage
import com.example.dogapiapplication.repositories.DogsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogImagesScreenViewModel(
    private val dogsRepository: DogsRepository
): ViewModel() {
    private val _dogImages = MutableStateFlow(emptyList<DogImage>())
    val dogImages: StateFlow<List<DogImage>> = _dogImages

    fun loadDogImages(id: String) {
        // Uncomment after implementing the repository
        viewModelScope.launch {
            _dogImages.value = dogsRepository.getDogImages(id)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as DogAPIApplication
                DogImagesScreenViewModel(
                    dogsRepository = application.dogsRepository
                )
            }
        }
    }
}