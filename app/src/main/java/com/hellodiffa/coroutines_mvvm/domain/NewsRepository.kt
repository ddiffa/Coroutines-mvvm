package com.hellodiffa.coroutines_mvvm.domain

import com.hellodiffa.coroutines_mvvm.data.model.Article

interface NewsRepository {
    suspend fun getAllArticle(): List<Article>?
}