package com.example.notepages.repositories

import com.example.notepages.models.NotePage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object NotePagesRepository {
    private val _notePages = MutableStateFlow(emptyList<NotePage>())
    val notePages: StateFlow<List<NotePage>> = _notePages

    fun addNotePage(notePage: NotePage) {
        _notePages.value += notePage
    }

    fun removeNotePage(notePage: NotePage) {
        _notePages.value -= notePage
    }

    fun updateNotePage(notePage: NotePage) {
        _notePages.value = _notePages.value.map {
            if (it.id == notePage.id) {
                notePage
            } else {
                it
            }
        }
    }
}