package com.hellodiffa.coroutines_mvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hellodiffa.coroutines_mvvm.data.source.NewsRepositoryImpl
import com.hellodiffa.coroutines_mvvm.domain.executor.Dispatcher
import com.hellodiffa.coroutines_mvvm.remote.Resource

class MainViewModel(
    private val repository: NewsRepositoryImpl,
    private val dispatcher: Dispatcher
) : ViewModel() {

    internal fun getArticle() = liveData(dispatcher.background()) {
        emit(Resource.loading(data = null))

        try {
            emit(Resource.success(data = repository.getAllArticle()))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occured!"))
        }
    }

}