package com.example.stateflowwithlists.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class NotesViewModel: ViewModel() {
    private val _notes = MutableStateFlow<List<String>>(emptyList())
    val notes: StateFlow<List<String>> = _notes

    fun addNote(note: String) {
        _notes.value += note
    }

    fun removeNote(note: String) {
        _notes.value -= note
    }
}