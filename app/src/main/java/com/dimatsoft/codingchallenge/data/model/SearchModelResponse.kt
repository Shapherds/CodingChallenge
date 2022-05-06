package com.dimatsoft.codingchallenge.data.model

data class SearchModelResponse(
    val id: String, //flickr.photos.search
    val owner: String,//37ad288835e4c64fc0cb8af3f3a1a65d
    val secret: String, // format
    val server: String, //1
    val farm: Int, //1
    val title: String,
    val ispublic: Int,
    val isfriend: Int,
    val isfamily: Int
)