package com.example.dogapiapplication.models


class Breed(val id: String, val subBreeds: List<Breed> = emptyList()) {
    val name = id.split("-").joinToString(" ") { it.replaceFirstChar {char -> char.titlecase()} }
}