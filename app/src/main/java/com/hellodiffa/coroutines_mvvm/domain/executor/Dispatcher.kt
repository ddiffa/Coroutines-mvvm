package com.hellodiffa.coroutines_mvvm.domain.executor

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO

interface Dispatcher {
    fun background(): CoroutineDispatcher

    companion object {
        val DEFAULT: Dispatcher = object : Dispatcher {
            override fun background(): CoroutineDispatcher = IO
        }
    }
}