package com.example.sampleapplication.data.article

import com.example.sampleapplication.data.model.Article
import kotlinx.coroutines.delay
import java.util.*

interface ArticleRepository {
    suspend fun fetchArticle(id: UUID): Article?
    suspend fun fetchArticleSlowly(id: UUID): Article?
}

class ArticleRepositoryImpl : ArticleRepository {

    override suspend fun fetchArticle(id: UUID): Article? {
        return null
    }

    override suspend fun fetchArticleSlowly(id: UUID): Article? {
        delay(3000)
        return null
    }
}