package com.dimatsoft.codingchallenge.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchModelRequest(
    @Json(name = "method")
    val method: String,
    @Json(name = "api_key")
    val api_key: String,
    @Json(name = "format")
    val format: String,
    @Json(name = "nojsoncallback")
    val nojsoncallback: Int,
    @Json(name = "safe_search")
    val safe_search: Int,
    @Json(name = "text")
    val text: String
)