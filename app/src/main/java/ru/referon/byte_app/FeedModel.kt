package ru.referon.byte_app

import ru.referon.byte_app.model.MainModel

data class FeedModel(
    val news: MainModel? = null,
    val date: List<String>? = null,
    val error: Boolean = false,
    val loading: Boolean = false
)

