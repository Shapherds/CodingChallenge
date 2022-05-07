package com.dimatsoft.codingchallenge.data.api

import com.dimatsoft.codingchallenge.data.model.PhotosSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {

    @GET("?method=flickr.photos.search&api_key=37ad288835e4c64fc0cb8af3f3a1a65d&format=json&nojsoncallback=1&safe_search=1&")
    suspend fun getImages(
        @Query("text") text: String,
        @Query("page") page: Int
    ): PhotosSearchResponse
}
