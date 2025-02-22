package com.example.notepages

import android.app.Application
import androidx.room.Room
import com.example.notepages.repositories.NotePagesRepository

class NotePagesApplication: Application() {
    private val db by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "note_pages_database"
        ).build()
    }
    val notePagesRepository by lazy {
        NotePagesRepository(db.notePagesDao)
    }
}