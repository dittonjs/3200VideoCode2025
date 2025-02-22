package com.example.notepages.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.notepages.NotePagesApplication
import com.example.notepages.models.NotePage
import com.example.notepages.repositories.NotePagesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotesScreenViewModel(
    private val notePagesRepository: NotePagesRepository
): ViewModel() {
    private val _notes = MutableStateFlow(emptyList<NotePage>())
    val notes: StateFlow<List<NotePage>> = _notes

    fun loadNotePages() {
        viewModelScope.launch {
            notePagesRepository.loadNotePages()
        }
    }

    init {
        viewModelScope.launch {
            notePagesRepository.notes.collect {
                _notes.value = it
            }
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as NotePagesApplication
                NotesScreenViewModel(
                    application.notePagesRepository
                )
            }
        }
    }

}