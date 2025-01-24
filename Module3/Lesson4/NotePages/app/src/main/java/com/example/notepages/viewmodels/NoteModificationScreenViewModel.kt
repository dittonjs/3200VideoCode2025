package com.example.notepages.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notepages.models.NotePage
import com.example.notepages.repositories.NotePagesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NoteModificationScreenViewModel: ViewModel() {
    private val _notePage = MutableStateFlow<NotePage?>(null)
    val notePage: StateFlow<NotePage?> = _notePage

    init {
        viewModelScope.launch {
            NotePagesRepository.notePages.collect {
                _notePage.value = it.find {
                    it.id == Destinations.NoteModification.noteId
                }
            }
        }
    }


    fun addNotePage(notePage: NotePage) {
        NotePagesRepository.addNotePage(notePage)
    }

    fun updateNotePage(notePage: NotePage) {
        NotePagesRepository.updateNotePage(notePage)
    }

}