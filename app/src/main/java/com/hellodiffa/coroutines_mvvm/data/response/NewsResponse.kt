package com.hellodiffa.coroutines_mvvm.data.response

data class NewsResponse(
    val totalResults: Int? = null,
    val articles: List<ArticlesItem?>? = null,
    val status: String? = null
)
