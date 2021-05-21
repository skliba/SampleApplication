package com.example.sampleapplication.data.saved_articles

import com.example.sampleapplication.data.model.Article

interface SavedArticlesRepository {
    suspend fun fetchSavedArticles(): List<Article>?
}

class SavedArticlesRepositoryImpl : SavedArticlesRepository {

    override suspend fun fetchSavedArticles(): List<Article>? {
        return null
    }
}