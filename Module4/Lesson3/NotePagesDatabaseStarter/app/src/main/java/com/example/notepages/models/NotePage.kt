package com.example.notepages.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NotePage(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    @ColumnInfo val title: String,
    @ColumnInfo val content: String
)