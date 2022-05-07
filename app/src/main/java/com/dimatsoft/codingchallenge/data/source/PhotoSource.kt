package com.dimatsoft.codingchallenge.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.dimatsoft.codingchallenge.domain.repository.LocalRepository
import java.io.IOException

class PhotoSource(
    private val localRepository: LocalRepository,
    private val searchText: String
) : PagingSource<Int, String>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        return try {
            val nextPage = params.key ?: INITIAL_PAGE
            val response = localRepository.getFlickObjects(searchText, nextPage)

            return LoadResult.Page(
                data = response,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (response.isEmpty()) null else nextPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return state.anchorPosition
    }

    private companion object {
        const val INITIAL_PAGE = 1
    }
}