package com.example.notepages

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notepages.daos.NotePagesDao
import com.example.notepages.models.NotePage

@Database(entities = [NotePage::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract val notePagesDao: NotePagesDao
}