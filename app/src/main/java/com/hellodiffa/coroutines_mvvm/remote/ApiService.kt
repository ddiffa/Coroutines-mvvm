package com.hellodiffa.coroutines_mvvm.remote

import com.hellodiffa.coroutines_mvvm.data.response.NewsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("top-headlines?country=id&category=technology&apiKey=apiKey")
    suspend fun getArticle() : NewsResponse
}