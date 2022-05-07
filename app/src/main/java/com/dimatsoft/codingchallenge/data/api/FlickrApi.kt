package com.dimatsoft.codingchallenge.data.api

import com.dimatsoft.codingchallenge.data.model.PhotosSearchResponse
import retrofit2.http.GET

interface FlickrApi {

    @GET("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=37ad288835e4c64fc0cb8af3f3a1a65d&format=json&nojsoncallback=1&safe_search=1&text=Heidelberg")
    suspend fun getImages(): PhotosSearchResponse
}
