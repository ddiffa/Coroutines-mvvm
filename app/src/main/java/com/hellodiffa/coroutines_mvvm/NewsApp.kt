package com.hellodiffa.coroutines_mvvm

import android.app.Application
import com.hellodiffa.coroutines_mvvm.di.moduleAPI
import com.hellodiffa.coroutines_mvvm.di.moduleDispatcher
import com.hellodiffa.coroutines_mvvm.di.moduleRepository
import com.hellodiffa.coroutines_mvvm.di.moduleViewModel
import org.koin.core.context.startKoin

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(moduleAPI, moduleRepository, moduleViewModel, moduleDispatcher)
        }
    }

}