package com.dimatsoft.codingchallenge.domain.model

data class SearchResult(
    val id: String,
    val secret: String,
    val server: String,
    val farm: Int
)