package com.example.animatedvisibility.models

var idCounter = 0

data class Todo(
    val id: Int = idCounter++,
    val title: String,
    val description: String,
    val isDone: Boolean = false
)