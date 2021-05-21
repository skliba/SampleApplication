package com.example.sampleapplication.data.wishlist

import java.util.*

interface WishlistRepository {
    suspend fun saveArticle(id: UUID): Boolean?
    suspend fun unsaveArticle(id: UUID): Boolean?
}

class WishlistRepositoryImpl : WishlistRepository {
    override suspend fun saveArticle(id: UUID): Boolean? {
        return null
    }

    override suspend fun unsaveArticle(id: UUID): Boolean? {
        return null
    }
}