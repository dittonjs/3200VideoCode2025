package com.example.models.viewmodels

import androidx.lifecycle.ViewModel
import com.example.models.models.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomePageViewModel: ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(listOf())
    val notes: StateFlow<List<Note>> = _notes

    fun addNote(note: Note) {
        _notes.value += note
    }

    fun removeNote(note: Note) {
        _notes.value.apply {
            _notes.value = filter { it.id != note.id }
        }
    }
}