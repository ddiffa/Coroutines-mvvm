package com.hellodiffa.coroutines_mvvm.di

import com.hellodiffa.coroutines_mvvm.data.source.NewsRepositoryImpl
import com.hellodiffa.coroutines_mvvm.domain.executor.Dispatcher
import com.hellodiffa.coroutines_mvvm.presentation.MainViewModel
import com.hellodiffa.coroutines_mvvm.remote.NewsAPI
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleAPI = module {
    single { NewsAPI.createService(get()) }
    single { NewsAPI.provideHttpClient() }
    single { NewsAPI.provideRetrofit(get()) }
}

val moduleRepository = module {
    single { NewsRepositoryImpl(get()) }
}

val moduleViewModel = module {
    viewModel { MainViewModel(get(),get()) }
}

val moduleDispatcher = module {
    single { Dispatcher.DEFAULT }
}