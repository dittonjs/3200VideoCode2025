package com.example.notepages.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notepages.models.NotePage
import com.example.notepages.repositories.NotePagesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotesScreenViewModel: ViewModel() {
    private val _notes = MutableStateFlow<List<NotePage>>(emptyList())
    val notes: StateFlow<List<NotePage>> = _notes

    init {
        viewModelScope.launch {
            NotePagesRepository.notePages.collect {
                _notes.value = it
            }
        }
    }
}