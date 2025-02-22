package com.example.notepages.repositories

import com.example.notepages.daos.NotePagesDao
import com.example.notepages.models.NotePage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NotePagesRepository(
    private val notePagesDao: NotePagesDao
) {
    private val _notes = MutableStateFlow(emptyList<NotePage>())
    val notes: StateFlow<List<NotePage>> = _notes

    suspend fun loadNotePages() {
        _notes.value = notePagesDao.getAllNotePages()
    }

    suspend fun addNotePage(
        title: String,
        content: String
    ) {
        val newNotePage = NotePage(
            title = title,
            content = content
        )
        newNotePage.id = notePagesDao.insertNotePage(newNotePage)
        _notes.value += newNotePage
    }

    suspend fun updateNotePage(
        noteId: Long,
        title: String,
        content: String
    ) {
        val updatedNotePage = NotePage(
            id = noteId,
            title = title,
            content = content
        )

        notePagesDao.updateNotePage(updatedNotePage)

        _notes.value = _notes.value.map { notePage ->
            if (notePage.id == noteId) {
                updatedNotePage
            } else {
                notePage
            }
        }
    }

    suspend fun deleteNotePage(
        noteId: Long
    ) {
        // TODO delete note page from database
        _notes.value = _notes.value.filter { notePage ->
            notePage.id != noteId
        }
    }
}