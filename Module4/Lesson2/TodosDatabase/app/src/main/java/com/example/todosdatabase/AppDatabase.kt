package com.example.todosdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todosdatabase.daos.TodosDao
import com.example.todosdatabase.models.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract val todosDao: TodosDao
}

// can do this also
//abstract fun todosDao(): TodosDao
