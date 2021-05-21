package com.example.sampleapplication.data.search

import com.example.sampleapplication.data.model.Article
import com.example.sampleapplication.data.server.Server
import kotlinx.coroutines.delay

interface SearchRepository {
    suspend fun getAllArticles(): List<Article>?
}

class SearchRepositoryImpl : SearchRepository {

    override suspend fun getAllArticles(): List<Article>? {
        delay(1000)
        return Server.getAllArticles()
    }
}