package com.hellodiffa.coroutines_mvvm.data.source

import com.hellodiffa.coroutines_mvvm.data.model.Article
import com.hellodiffa.coroutines_mvvm.domain.NewsRepository
import com.hellodiffa.coroutines_mvvm.remote.ApiService

class NewsRepositoryImpl(private val api: ApiService) : NewsRepository {
    override suspend fun getAllArticle(): List<Article>? {
        return api.getArticle().articles?.map {
            Article(
                id = 0,
                image = it?.urlToImage.toString(),
                title = it?.title.toString()
            )
        }
    }

}