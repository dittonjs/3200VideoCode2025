package com.example.todosdatabase.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Todo(
    @ColumnInfo val content: String,
    @ColumnInfo(name = "is_completed") val isCompleted: Boolean
) {
    @PrimaryKey(autoGenerate = true) var id: Long? = null
}
