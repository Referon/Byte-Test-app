package ru.referon.byte_app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.referon.byte_app.FeedModel
import ru.referon.byte_app.repository.RepositoryImpl
import java.lang.Exception

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = RepositoryImpl()
    private val _data = MutableLiveData(FeedModel())
    val data: LiveData<FeedModel>
        get() = _data

    fun loadNews(category: String){

        _data.value = FeedModel(loading = true)
        viewModelScope.launch {
            try {
                val news = repository.getNewsByCategory(category)
                _data.value = FeedModel(news = news)
            }catch (e: Exception){
                _data.value = FeedModel(error = true)
            }
        }
    }
}