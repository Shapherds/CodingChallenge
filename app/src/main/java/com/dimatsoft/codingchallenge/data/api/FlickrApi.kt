package com.dimatsoft.codingchallenge.data.api

import com.dimatsoft.codingchallenge.data.model.SearchModelRequest
import com.dimatsoft.codingchallenge.data.model.SearchModelResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface FlickrApi {

    @GET("?")
    suspend fun getImages(@Body searchModelRequest: SearchModelRequest): List<SearchModelResponse>
}