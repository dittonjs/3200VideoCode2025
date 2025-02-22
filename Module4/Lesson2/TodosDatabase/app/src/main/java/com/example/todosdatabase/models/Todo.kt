package com.example.todosdatabase.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    @ColumnInfo val content: String,
    @ColumnInfo val isCompleted: Boolean = false
)
