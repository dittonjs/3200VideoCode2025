package com.example.todosdatabase.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todosdatabase.models.Todo

@Dao
abstract class TodosDao {

    @Query("SELECT * FROM Todo")
    abstract suspend fun getAllTodos(): List<Todo>

    @Insert
    abstract suspend fun insertTodo(todo: Todo): Long

    @Update
    abstract suspend fun updateTodo(todo: Todo)
}