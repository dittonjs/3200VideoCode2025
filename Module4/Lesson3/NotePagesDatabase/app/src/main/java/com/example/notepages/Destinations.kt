package com.example.notepages

import kotlinx.serialization.Serializable

class Destinations {
    @Serializable object Notes
    @Serializable class NoteModification(val noteId: Long? = null)
}