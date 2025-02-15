package com.example.notepages

import android.app.Application
import com.example.notepages.repositories.NotePagesRepository

class NotePagesApplication: Application() {
    val notePagesRepository = NotePagesRepository
}