package com.dimatsoft.codingchallenge.data.model

data class SearchModelRequest(
    val method: String,
    val api_key: String,
    val format: String,
    val nojsoncallback: Int,
    val safe_search: Int,
    val text: String
)