package com.example.sampleapplication.data.model

import java.util.*

data class Article(
    val id: UUID,
    val name: String,
    val onWishlist: Boolean,
    val description: String
)