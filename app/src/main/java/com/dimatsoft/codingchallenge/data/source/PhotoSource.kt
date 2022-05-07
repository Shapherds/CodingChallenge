package com.dimatsoft.codingchallenge.data.source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import com.dimatsoft.codingchallenge.domain.repository.LocalRepository

class PhotoSource(
    private val localRepository: LocalRepository,
    private val searchText: String
) : PagingSource<Int, SearchResult>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchResult> {
        val nextPage = params.key ?: INITIAL_PAGE

        val response =
            localRepository.getFlickObjects(searchText, nextPage)
        return LoadResult.Page(
            data = response,
            prevKey = if (nextPage == 1) null else nextPage - 1,
            nextKey = if (response.isEmpty()) null else nextPage + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, SearchResult>): Int? {
        return state.anchorPosition
    }

    companion object {
        const val LIMIT = 6
        private const val INITIAL_PAGE = 1
    }
}