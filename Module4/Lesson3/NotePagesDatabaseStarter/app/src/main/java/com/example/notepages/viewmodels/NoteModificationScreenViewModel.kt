package com.example.notepages.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.notepages.NotePagesApplication

import com.example.notepages.repositories.NotePagesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class NoteModificationScreenViewModel(
    private val noteId: Long?,
    private val notePagesRepository: NotePagesRepository
): ViewModel() {
    private val _title = MutableStateFlow("")
    private val _content = MutableStateFlow("")

    val title: StateFlow<String> = _title
    val content: StateFlow<String> = _content

    fun setTitle(title: String) {
        _title.value = title
    }

    fun setContent(content: String) {
        _content.value = content
    }

    fun saveNote() {
        if (noteId != null) {
            notePagesRepository.updateNotePage(
                noteId,
                _title.value,
                _content.value
            )
        } else {
            notePagesRepository.addNotePage(
                _title.value,
                _content.value
            )
        }
    }

    init {
        if (noteId != null) {
            viewModelScope.launch {
                notePagesRepository.notes.collect { notes ->
                    val note = notes.find { it.id == noteId }
                    if (note != null) {
                        _title.value = note.title
                        _content.value = note.content
                    }
                }
            }
        }
    }

    companion object {
        val NOTE_ID_KEY = object : CreationExtras.Key<Long?> {}

        val Factory = viewModelFactory {
            initializer {
                val noteId = this[NOTE_ID_KEY]
                val application = this[APPLICATION_KEY] as NotePagesApplication
                NoteModificationScreenViewModel(
                    noteId,
                    application.notePagesRepository
                )
            }
        }
    }
}
