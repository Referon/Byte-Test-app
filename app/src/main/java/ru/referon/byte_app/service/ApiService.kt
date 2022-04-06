package ru.referon.byte_app.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.referon.byte_app.model.MainModel

private val BASE_URL = "https://newsapi.org/v2/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("top-headlines?country=ru&apiKey=f0d5f2dbf0a84a448ce0bbf5931e8fe4")
    suspend fun getNewsByCategory(@Query("category") category: String): MainModel

}
object NewsApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}