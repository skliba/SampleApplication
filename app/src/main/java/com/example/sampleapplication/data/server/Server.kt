package com.example.sampleapplication.data.server

import com.example.sampleapplication.data.model.Article
import java.util.*

interface ApiService {
    fun getArticle(id: UUID): Article?
    fun getSavedArticles(): List<Article>?
    fun getAllArticles(): List<Article>?
    fun getArticles(query: String): List<Article>?
    fun saveArticle(id: UUID): Boolean?
    fun unsaveArticle(id: UUID): Boolean?
}

/**
This class represents the backend i.e. the API and the currentArticles represents the database
entries.
 */
object Server : ApiService {

    private var hasConnection = true

    private var currentArticles = listOf(
        Article(UUID.randomUUID(), "Playstation 5", false, "This is a new gaming console"),
        Article(UUID.randomUUID(), "Playstation 4", false, "This is a cool and old gaming console"),
        Article(UUID.randomUUID(), "Playstation 3", false, "This is an older gaming console"),
        Article(UUID.randomUUID(), "Playstation 2", false, "This is an ancient gaming console"),
        Article(UUID.randomUUID(), "Pixel 5", false, "The newest Pixel phone from Google"),
        Article(UUID.randomUUID(), "Pixel 4", false, "The latest Pixel phones from Google"),
        Article(UUID.randomUUID(), "Pixel 4A", false, "The lower end Pixel phones from Google"),
        Article(UUID.randomUUID(), "Pixel 3", false, "The older line of Pixel phones from Google"),
        Article(UUID.randomUUID(), "Mountain Bike", false, "Great bike for going over mountains"),
        Article(UUID.randomUUID(), "City Bike", false, "Great bike for going through cities"),
        Article(UUID.randomUUID(), "Tesla Model S", false, "A 700 horsepower electric car"),
        Article(UUID.randomUUID(), "Tesla Model 3", false, "A 300 horsepower electric car"),
        Article(UUID.randomUUID(), "Ferrari 458 Italia", false, "450 horsepower Ferrari"),
    )

    fun disableConnection() {
        hasConnection = false
    }

    fun enableConnection() {
        hasConnection = true
    }

    override fun getArticle(id: UUID) = doIfConnected { currentArticles.find { it.id == id } }
    override fun getSavedArticles() = doIfConnected { currentArticles.filter { it.onWishlist } }
    override fun getAllArticles() = doIfConnected { currentArticles }
    override fun getArticles(query: String) = doIfConnected {
        currentArticles.filter { it.name.startsWith(query) }
    }

    override fun saveArticle(id: UUID) = doIfConnected {
        val searchedArticle = currentArticles.find { it.id == id }
        searchedArticle?.let {
            val index = currentArticles.indexOf(it)
            val savedArticle = it.copy(onWishlist = true)
            currentArticles = currentArticles.replace(index, savedArticle)
            return true
        }
        false
    }

    override fun unsaveArticle(id: UUID) = doIfConnected {
        val searchedArticle = currentArticles.find { it.id == id }
        searchedArticle?.let {
            val index = currentArticles.indexOf(it)
            val savedArticle = it.copy(onWishlist = false)
            currentArticles = currentArticles.replace(index, savedArticle)
            return true
        }
        false
    }

    private fun <E> Iterable<E>.replace(index: Int, elem: E) = mapIndexed { i, existing ->
        if (i == index) elem else existing
    }

    private inline fun <T> doIfConnected(block: () -> T): T? {
        if (hasConnection) block()
        return null
    }
}