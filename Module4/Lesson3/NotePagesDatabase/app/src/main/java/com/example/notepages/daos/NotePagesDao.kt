package com.example.notepages.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notepages.models.NotePage

@Dao
abstract class NotePagesDao {
    @Query("SELECT * FROM NotePage")
    abstract suspend fun getAllNotePages(): List<NotePage>

    @Insert
    abstract suspend fun insertNotePage(notePage: NotePage): Long

    @Update
    abstract suspend fun updateNotePage(notePage: NotePage)
}