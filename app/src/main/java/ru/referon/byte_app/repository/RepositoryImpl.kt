package ru.referon.byte_app.repository

import ru.referon.byte_app.model.MainModel
import ru.referon.byte_app.service.NewsApi

class RepositoryImpl {

    suspend fun getNewsByCategory(category: String): MainModel = NewsApi.retrofitService.getNewsByCategory(category)

}