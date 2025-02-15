package com.example.notepages.repositories

import com.example.notepages.models.NotePage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object NotePagesRepository {
    private var idCounter = 0
    private val _notes = MutableStateFlow(emptyList<NotePage>())
    val notes: StateFlow<List<NotePage>> = _notes

    init {
        addNotePage(
            title = "First Note",
            content = "This is the first note."
        )
        addNotePage(
            title = "Second Note",
            content = "This is the second note."
        )
    }

    fun addNotePage(
        title: String,
        content: String
    ) {
        val newNotePage = NotePage(
            id = ++idCounter,
            title = title,
            content = content
        )
        _notes.value += newNotePage
    }

    fun updateNotePage(
        noteId: Int,
        title: String,
        content: String
    ) {
        val updatedNotePage = NotePage(
            id = noteId,
            title = title,
            content = content
        )
        _notes.value = _notes.value.map { notePage ->
            if (notePage.id == noteId) {
                updatedNotePage
            } else {
                notePage
            }
        }
    }

    fun deleteNotePage(
        noteId: Int
    ) {
        _notes.value = _notes.value.filter { notePage ->
            notePage.id != noteId
        }
    }
}