package com.example.todosdatabase.models

var currentId = 0

data class Todo(
    val id: Int = currentId++,
    val content: String = "",
    val isCompleted: Boolean = false
)
