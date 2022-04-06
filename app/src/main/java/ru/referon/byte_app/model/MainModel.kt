package ru.referon.byte_app.model

data class MainModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)