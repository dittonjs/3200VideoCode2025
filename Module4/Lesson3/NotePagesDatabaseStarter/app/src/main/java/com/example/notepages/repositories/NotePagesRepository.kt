package com.example.notepages.repositories

import com.example.notepages.models.NotePage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object NotePagesRepository {
    private val _notes = MutableStateFlow(emptyList<NotePage>())
    val notes: StateFlow<List<NotePage>> = _notes
    
    fun addNotePage(
        title: String,
        content: String
    ) {
        val newNotePage = NotePage(
            title = title,
            content = content
        )
        // TODO insert note page into database
        _notes.value += newNotePage
    }

    fun updateNotePage(
        noteId: Long,
        title: String,
        content: String
    ) {
        val updatedNotePage = NotePage(
            id = noteId,
            title = title,
            content = content
        )

        // TODO update note page in database
        _notes.value = _notes.value.map { notePage ->
            if (notePage.id == noteId) {
                updatedNotePage
            } else {
                notePage
            }
        }
    }

    fun deleteNotePage(
        noteId: Long
    ) {
        // TODO delete note page from database
        _notes.value = _notes.value.filter { notePage ->
            notePage.id != noteId
        }
    }
}